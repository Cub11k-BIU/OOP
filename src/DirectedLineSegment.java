/**
 * DirectedLineSegment.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class DirectedLineSegment {
    private LineSegment lineSegment;

    /**
     * Constructor.
     *
     * @param start start point
     * @param end end point
     */
    public DirectedLineSegment(Point start, Point end) {
        this.lineSegment = new LineSegment(start, end);
    }

    /**
     * Construct a DirectedLineSegment from another directed line segment.
     *
     * @param l directed line segment to copy
     */
    public DirectedLineSegment(DirectedLineSegment l) {
        this.lineSegment = new LineSegment(l.lineSegment);
    }

    /**
     * Getter for start point.
     *
     * @return start point
     */
    public Point getStart() {
        return this.lineSegment.getP1();
    }

    /**
     * Getter for end point.
     *
     * @return end point
     */
    public Point getEnd() {
        return this.lineSegment.getP2();
    }

    /**
     * Setter for start point.
     *
     * @param start start point
     */
    public void setStart(Point start) {
        this.lineSegment.setP1(start);
    }

    /**
     * Setter for end point.
     *
     * @param end end point
     */
    public void setEnd(Point end) {
        this.lineSegment.setP2(end);
    }

    /**
     * Length of `this` line segment.
     *
     * @return length
     */
    public double length() {
        return this.lineSegment.length();
    }

    /**
     * Middle point of `this` line segment.
     *
     * @return middle
     */
    public Point middle() {
        return this.lineSegment.middle();
    }

    /**
     * Determine whether `this` has the same start-end-points as `other`.
     *
     * @param other directed line segment to compare against
     * @return `true` if line segments have the same start-end-points, `false` otherwise
     */
    public boolean isEqual(DirectedLineSegment other) {
        return this.getStart().isEqual(other.getStart()) && this.getEnd().isEqual(other.getEnd());
    }

    /**
     * Return the inverse of `this`, e.g. swap `start` and `end`.
     *
     * @return inverse
     */
    public DirectedLineSegment inverse() {
        return new DirectedLineSegment(this.getEnd(), this.getStart());
    }

    /**
     * Return the line segment of `this`, direction does not matter.
     *
     * @return line segment
     */
    public LineSegment toLineSegment() {
        return new LineSegment(this.lineSegment);
    }
}
