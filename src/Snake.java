/**
 * Snake — slides a player down from start to end (start &gt; end).
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Snake extends BoardEntity {
    /**
     * Construct a snake from start to end.
     *
     * @param start the head cell
     * @param end   the tail cell (must be strictly less than start)
     */
    public Snake(int start, int end) {
        super(start, end);
    }
}
