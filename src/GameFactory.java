import java.util.List;

/**
 * GameFactory — central construction point for the game's stub-backed types.
 *
 * <p>Tests obtain boards, entities, players and engines through this factory so
 * the grader can run a suite against a reference implementation.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public final class GameFactory {
    private GameFactory() {
    }

    /**
     * Create a board.
     *
     * @param size     the number of cells
     * @param entities the snakes and ladders
     * @return a new board
     */
    public static Board board(int size, List<BoardEntity> entities) {
        return new Board(size, entities);
    }

    /**
     * Create a snake.
     *
     * @param start the head cell
     * @param end   the tail cell
     * @return a new snake
     */
    public static Snake snake(int start, int end) {
        return new Snake(start, end);
    }

    /**
     * Create a ladder.
     *
     * @param start the bottom cell
     * @param end   the top cell
     * @return a new ladder
     */
    public static Ladder ladder(int start, int end) {
        return new Ladder(start, end);
    }

    /**
     * Create a player at position 0.
     *
     * @param name the player name
     * @return a new player
     */
    public static Player player(String name) {
        return new Player(name);
    }

    /**
     * Create a game engine.
     *
     * @param board   the board
     * @param players the players
     * @param dice    the dice
     * @return a new engine
     */
    public static GameEngine engine(Board board, List<Player> players, Dice dice) {
        return new GameEngine(board, players, dice);
    }
}
