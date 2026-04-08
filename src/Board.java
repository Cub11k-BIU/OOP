import java.util.List;

/**
 * Board — immutable board configuration.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Board {
    /**
     * Construct an immutable board.
     *
     * @param size     the number of cells on the board
     * @param entities the snakes and ladders on this board
     */
    public Board(int size, List<BoardEntity> entities) {
    }

    /**
     * Return the board size.
     *
     * @return the number of cells
     */
    public int getSize() {
        return 0;
    }

    /**
     * Return the destination cell after applying any snake or ladder
     * starting at {@code cell}, or {@code cell} itself if none.
     *
     * @param cell the cell to query
     * @return the cell to move to
     */
    public int getDestination(int cell) {
        return 0;
    }
}
