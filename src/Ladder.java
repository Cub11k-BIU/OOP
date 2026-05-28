/**
 * Ladder — climbs a player up from start to end (start &lt; end).
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Ladder extends BoardEntity {
    /**
     * <b>Stub:</b> construct a ladder, validating that it climbs up.
     *
     * <p>Throw {@link IllegalArgumentException} unless {@code start} is
     * strictly less than {@code end}.
     *
     * @param start the bottom cell
     * @param end   the top cell (must be strictly greater than start)
     */
    public Ladder(int start, int end) {
        super(start, end);
    }
}
