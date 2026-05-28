import java.util.List;

/**
 * Board — concrete board. Complete the transport lookup below.
 *
 * <p>The size and the immutable entity list are held by
 * {@link AbstractBoard} ({@code getSize()} and {@code entities()} are
 * provided); implement {@link #getDestination(int)}.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Board extends AbstractBoard {
    /**
     * Construct an immutable board.
     *
     * @param size     the number of cells on the board
     * @param entities the snakes and ladders on this board
     */
    public Board(int size, List<BoardEntity> entities) {
        super(size, entities);
    }

    /**
     * Return the destination cell after applying any snake or ladder
     * starting at {@code cell}, or {@code cell} itself if none.
     *
     * @param cell the cell to query
     * @return the cell to move to
     */
    @Override
    public int getDestination(int cell) {
        return 0;
    }
}
