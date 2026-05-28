/**
 * BoardEntity — abstract base for snakes and ladders.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public abstract class BoardEntity {
    private final int start;
    private final int end;

    /**
     * Construct with start and end cells.
     *
     * @param start the cell where this entity begins
     * @param end   the cell where this entity ends (i.e. transports to)
     */
    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Return the start cell.
     *
     * @return the start cell
     */
    public int getStart() {
        return start;
    }

    /**
     * Return the end (destination) cell.
     *
     * @return the end cell
     */
    public int getEnd() {
        return end;
    }
}
