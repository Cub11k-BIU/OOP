/**
 * Point.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class Point {
    private double x;
    private double y;

    /**
     * Construct a Point with coordinates `(x, y)`.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construct a Point from another Point.
     *
     * @param p point to copy
     */
    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Getter for coordinate x.
     *
     * @return coordinate x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter for coordinate y.
     *
     * @return coordinate y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Setter for coordinate x.
     *
     * @param x coordinate x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter for coordinate y.
     *
     * @param y coordinate y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Euclidean distance from `this` to `other`.
     *
     * @param other point to calculate distance from
     * @return distance
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    /**
     * Determine whether `this` has the same coordinates as `other`.
     *
     * @param other point to compare against
     * @return `true` if points have the same coordinates, `false` otherwise
     */
    public boolean isEqual(Point other) {
        return DoubleComparator.isEqual(this.x, other.x) && DoubleComparator.isEqual(this.y, other.y);
    }

    /**
     * Determine whether `this` belongs to line segment `l`.
     *
     * @param l line to check belonging to
     * @return `true` if `this` belongs to line segment `l`, `false` otherwise
     */
    public boolean belongsTo(LineSegment l) {
        return PointSegmentIntersection.intersects(this, l);
    }
}
