import java.util.List;

/**
 * AbstractBoard — provided immutable board state.
 *
 * <p>Holds the size and the snakes/ladders; {@link #getSize()} is {@code final}.
 * The {@code getDestination} lookup is left abstract for the {@code Board}
 * subclass to implement.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public abstract class AbstractBoard {
    private final int size;
    private final List<BoardEntity> entities;

    /**
     * Construct an immutable board.
     *
     * @param size     the number of cells on the board
     * @param entities the snakes and ladders on this board
     */
    protected AbstractBoard(int size, List<BoardEntity> entities) {
        this.size = size;
        this.entities = List.copyOf(entities);
    }

    /**
     * Return the board size.
     *
     * @return the number of cells
     */
    public final int getSize() {
        return size;
    }

    /**
     * Return the snakes and ladders on this board.
     *
     * @return the board entities
     */
    protected final List<BoardEntity> entities() {
        return entities;
    }

    /**
     * Return the destination cell after applying any snake or ladder
     * starting at {@code cell}, or {@code cell} itself if none.
     *
     * @param cell the cell to query
     * @return the cell to move to
     */
    public abstract int getDestination(int cell);
}
