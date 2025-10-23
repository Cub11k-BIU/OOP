/**
 * LineSegment.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class LineSegment {
    private Point p1;
    private Point p2;

    /**
     * Construct a LineSegment with ends `p1` and `p2`.
     *
     * @param p1 first point
     * @param p2 second point
     */
    public LineSegment(Point p1, Point p2) {
        this.p1 = new Point(p1.getX(), p1.getY());
        this.p2 = new Point(p2.getX(), p2.getY());
    }

    /**
     * Getter for first point.
     *
     * @return point p1
     */
    public Point getP1() {
        return new Point(this.p1.getX(), this.p1.getY());
    }

    /**
     * Getter for second point.
     *
     * @return point p2
     */
    public Point getP2() {
        return new Point(this.p2.getX(), this.p2.getY());
    }

    /**
     * Setter for point p1.
     *
     * @param p1 first point
     */
    public void setP1(Point p1) {
        this.p1 = new Point(p1.getX(), p1.getY());
    }

    /**
     * Setter for point p2.
     *
     * @param p2 second point
     */
    public void setP2(Point p2) {
        this.p2 = new Point(p2.getX(), p2.getY());
    }

    /**
     * Length of `this` line segment.
     *
     * @return length
     */
    public double length() {
        return this.p1.distance(this.p2);
    }

    /**
     * Middle point of `this` line segment.
     *
     * @return middle
     */
    public Point middle() {
        double xMid = (this.p1.getX() + this.p2.getX()) / 2.0;
        double yMid = (this.p1.getY() + this.p2.getY()) / 2.0;
        return new Point(xMid, yMid);
    }

    /**
     * Determine whether `this` has the same end-points as `other`.
     *
     * @param other line segment to compare against
     * @return `true` if line segments have the same end-points, `false` otherwise
     */
    public boolean isEqual(LineSegment other) {
        Point otherP1 = other.getP1();
        Point otherP2 = other.getP2();
        return (this.p1.isEqual(otherP1) && this.p2.isEqual(otherP2))
                || (this.p1.isEqual(otherP2) && this.p2.isEqual(otherP1));
    }

    /**
     * Determine whether `this` contains point `p`.
     *
     * @param p point to check belonging of
     * @return `true` if `this` belongs to line segment `l`, `false` otherwise
     */
    public boolean contains(Point p) {
        return PointSegmentIntersection.intersects(p, this);
    }

    /**
     * Determine whether `this` and `other` intersect.
     *
     * @param other line segment
     * @return `true` if there is an intersection, `false` otherwise.
     */
    public boolean intersectsWith(LineSegment other) {
        return new SegmentSegmentIntersection(this, other).intersects();
    }

    /**
     * Find the intersection segment between `this` and `other`.
     *
     * @param other line segment
     * @return intersection line segment
     */
    public LineSegment intersectionSegment(LineSegment other) {
        return new SegmentSegmentIntersection(this, other).intersectionSegment();
    }
}
