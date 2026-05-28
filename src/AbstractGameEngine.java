import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractGameEngine — provided turn orchestration for Snakes and Ladders.
 *
 * <p>{@code playTurn} and the I/O / accessor methods are {@code final}; each
 * per-roll decision is delegated to the abstract stub methods
 * {@link #isOvershoot}, {@link #applyRoll} and {@link #isWinningPosition},
 * which the concrete {@code GameEngine} subclass implements.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public abstract class AbstractGameEngine {
    private static final int EXTRA_TURN_ROLL = 6;

    private final AbstractBoard board;
    private final Dice dice;
    private final List<TurnSnapshot> history;
    private List<Player> currentPlayers;
    private int currentIndex;
    private boolean gameOver;
    private Player winner;

    /**
     * Construct an engine.
     *
     * @param board   the board
     * @param players the players (must contain at least 2)
     * @param dice    the dice
     * @throws IllegalArgumentException if fewer than 2 players are provided
     */
    protected AbstractGameEngine(AbstractBoard board, List<Player> players, Dice dice) {
        if (players == null || players.size() < 2) {
            throw new IllegalArgumentException("GameEngine requires at least 2 players");
        }
        this.board = board;
        this.dice = dice;
        this.currentPlayers = new ArrayList<>(players);
        this.history = new ArrayList<>();
        this.currentIndex = 0;
        this.gameOver = false;
        this.winner = null;
    }

    /**
     * Return the board this engine plays on.
     *
     * @return the board
     */
    protected final AbstractBoard getBoard() {
        return board;
    }

    /**
     * Return true iff rolling {@code rollValue} from {@code currentPosition}
     * would move past the final cell.
     *
     * @param currentPosition the player's current position
     * @param rollValue       the dice roll
     * @return whether the move overshoots the final cell
     */
    public abstract boolean isOvershoot(int currentPosition, int rollValue);

    /**
     * Return the resulting position after rolling {@code rollValue} from
     * {@code currentPosition}: unchanged on an overshoot, otherwise the cell
     * reached after applying any snake or ladder transport.
     *
     * @param currentPosition the player's current position
     * @param rollValue       the dice roll
     * @return the resulting board position
     */
    public abstract int applyRoll(int currentPosition, int rollValue);

    /**
     * Return true iff {@code position} is the board's final (winning) cell.
     *
     * @param position the position to test
     * @return whether the position wins the game
     */
    public abstract boolean isWinningPosition(int position);

    /**
     * Advance the game by one turn (no-op if the game is over).
     */
    public final void playTurn() {
        if (gameOver) {
            return;
        }
        Player mover = currentPlayers.get(currentIndex);
        int rolled = dice.roll();
        boolean overshoot = isOvershoot(mover.getPosition(), rolled);

        List<Player> nextPlayers;
        if (overshoot) {
            nextPlayers = currentPlayers;
        } else {
            int destination = applyRoll(mover.getPosition(), rolled);
            Player moved = mover.moveTo(destination);
            nextPlayers = new ArrayList<>(currentPlayers);
            nextPlayers.set(currentIndex, moved);
            if (isWinningPosition(destination)) {
                gameOver = true;
                winner = moved;
            }
        }

        history.add(new TurnSnapshot(mover.getName(), rolled, nextPlayers));
        currentPlayers = nextPlayers;

        if (gameOver) {
            return;
        }
        boolean extraTurn = !overshoot && rolled == EXTRA_TURN_ROLL;
        if (!extraTurn) {
            currentIndex = (currentIndex + 1) % currentPlayers.size();
        }
    }

    /**
     * Return whether the game is over.
     *
     * @return true if game over
     */
    public final boolean isGameOver() {
        return gameOver;
    }

    /**
     * Return the winning player, or null if no winner yet.
     *
     * @return the winner
     */
    public final Player getWinner() {
        return winner;
    }

    /**
     * Return the player whose turn is next.
     *
     * @return the current player
     */
    public final Player getCurrentPlayer() {
        return currentPlayers.get(currentIndex);
    }

    /**
     * Return the full game history.
     *
     * @return the history
     */
    public final List<TurnSnapshot> getHistory() {
        return history;
    }

    /**
     * Save the game history to a file in the locked format
     * {@code <name> rolled <value> : <p1> <p2> ...}, one line per turn.
     *
     * @param filename the file name
     */
    public final void saveHistory(String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filename))) {
            for (TurnSnapshot snap : history) {
                StringBuilder sb = new StringBuilder();
                sb.append(snap.getName())
                        .append(" rolled ")
                        .append(snap.getRolled())
                        .append(" :");
                for (Player p : snap.getPlayers()) {
                    sb.append(' ').append(p.getPosition());
                }
                writer.write(sb.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
