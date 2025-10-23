/**
 * DirectedLineSegment.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class DirectedLineSegment {
    /**
     * Constructor.
     *
     * @param start start point
     * @param end end point
     */
    public DirectedLineSegment(Point start, Point end) {
    }

    /**
     * Getter for start point.
     *
     * @return start point
     */
    public Point getStart() {
    }

    /**
     * Getter for end point.
     *
     * @return end point
     */
    public Point getEnd() {
    }

    /**
     * Setter for start point.
     *
     * @param start start point
     */
    public void setStart(Point start) {
    }

    /**
     * Setter for end point.
     *
     * @param end end point
     */
    public void setEnd(Point end) {
        // ...
    }

    /**
     * Length of `this` line segment.
     *
     * @return length
     */
    public double length() {
        // ...
    }

    /**
     * Middle point of `this` line segment.
     *
     * @return middle
     */
    public Point middle() {
    }

    /**
     * Determine whether `this` has the same start-end-points as `other`.
     *
     * @param other directed line segment to compare against
     * @return `true` if line segments have the same start-end-points, `false` otherwise
     */
    public boolean isEqual(DirectedLineSegment other) {
    }

    /**
     * Return the inverse of `this`, e.g. swap `start` and `end`.
     *
     * @return inverse
     */
    public DirectedLineSegment inverse() {
    }

    /**
     * Return the line segment of `this`, direction does not matter.
     *
     * @return line segment
     */
    public LineSegment toLineSegment() {
    }
}
