/**
 * Ladder — climbs a player up from start to end (start &lt; end).
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Ladder extends BoardEntity {
    /**
     * Construct a ladder from start to end.
     *
     * @param start the bottom cell
     * @param end   the top cell (must be strictly greater than start)
     */
    public Ladder(int start, int end) {
        super(start, end);
    }
}
