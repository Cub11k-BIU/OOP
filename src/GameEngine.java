import java.util.List;

/**
 * GameEngine — concrete engine. Complete the three per-roll decisions below.
 *
 * <p>The turn loop, history and file I/O are provided by
 * {@link AbstractGameEngine}; the board is available via {@code getBoard()}.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class GameEngine extends AbstractGameEngine {
    /**
     * Construct an engine.
     *
     * @param board   the board
     * @param players the players (must contain at least 2)
     * @param dice    the dice
     */
    public GameEngine(Board board, List<Player> players, Dice dice) {
        super(board, players, dice);
    }

    /**
     * <b>Stub:</b> implement this method.
     *
     * <p>Return {@code true} iff rolling {@code rollValue} from
     * {@code currentPosition} would move past the final cell.
     *
     * @param currentPosition the player's current position
     * @param rollValue       the dice roll
     * @return whether the move overshoots the final cell
     */
    @Override
    public boolean isOvershoot(int currentPosition, int rollValue) {
        return false;
    }

    /**
     * <b>Stub:</b> implement this method.
     *
     * <p>Return the resulting position after rolling {@code rollValue} from
     * {@code currentPosition}: unchanged on an overshoot, otherwise the cell
     * reached after applying any snake or ladder transport.
     *
     * @param currentPosition the player's current position
     * @param rollValue       the dice roll
     * @return the resulting board position
     */
    @Override
    public int applyRoll(int currentPosition, int rollValue) {
        return 0;
    }

    /**
     * <b>Stub:</b> implement this method.
     *
     * <p>Return {@code true} iff {@code position} is the board's final
     * (winning) cell.
     *
     * @param position the position to test
     * @return whether the position wins the game
     */
    @Override
    public boolean isWinningPosition(int position) {
        return false;
    }
}
