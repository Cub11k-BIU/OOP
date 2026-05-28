/**
 * Snake — slides a player down from start to end (start &gt; end).
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Snake extends BoardEntity {
    /**
     * <b>Stub:</b> construct a snake, validating that it slides down.
     *
     * <p>Throw {@link IllegalArgumentException} unless {@code start} is
     * strictly greater than {@code end}.
     *
     * @param start the head cell
     * @param end   the tail cell (must be strictly less than start)
     */
    public Snake(int start, int end) {
        super(start, end);
    }
}
