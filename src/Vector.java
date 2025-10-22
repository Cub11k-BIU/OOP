/**
 * Vector.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class Vector {
    private Point p;
    private double length;
    private double direction;

    /**
     * Constructor.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Vector(double x, double y) {
        this.p = new Point(x, y);
        this.length = calculateLength(this.p);
        this.direction = calculateDirection(this.p);
    }

    /**
     * Return the `x` coordinate of this vector.
     *
     * @return coordinate x
     */
    public double getX() {
        return this.p.getX();
    }

    /**
     * Return the `y` coordinate of this vector.
     *
     * @return coordinate y
     */
    public double getY() {
        return this.p.getY();
    }

    /**
     * Return the length of this vector.
     *
     * @return length
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Return the direction of this vector represented as a signed angle in radians(not degrees)
     * between this vector and positive axis X.
     *
     * @return direction
     */
    public double getDirection() {
        return this.direction;
    }

    /**
     * Assign the `x` coordinate of this vector.
     *
     * @param x coordinate x
     */
    public void setX(double x) {
        this.setPoint(x, this.p.getY());
    }

    /**
     * Assign the `y` coordinate of this vector.
     *
     * @param y coordinate y
     */
    public void setY(double y) {
        this.setPoint(this.p.getX(), y);
    }

    /**
     * Assign the length of this vector, don't forget to preserve the direction.
     *
     * @param length length
     */
    public void setLength(double length) {
        this.length = length;
        this.p = calculatePoint(this.length, this.direction);
    }

    /**
     * Assign the direction of this vector, don't forget to preserve the length.
     *
     * @param direction direction (angle in radians)
     */
    public void setDirection(double direction) {
        this.direction = direction;
        this.p = calculatePoint(this.length, this.direction);
    }

    /**
     * Return the coordinates representation of this vector.
     *
     * @return point
     */
    public Point coordinates() {
        return new Point(this.getX(), this.getY());
    }

    /**
     * Return `true` if `this` represents the same equivalence class as `other`.
     *
     * @param other vector to compare against
     * @return `true` if `this` and `other` are the same vector mathematically, `false` otherwise.
     */
    public boolean isEqual(Vector other) {
        return this.p.isEqual(other.coordinates());
    }

    /**
     * Add vector `other` to `this` in-place (modify `this`).
     *
     * @param other vector to add
     */
    public void add(Vector other) {
        Vector sum = sum(this, other);
        this.setPoint(sum.getX(), sum.getY());
    }

    /**
     * Return the vector sum of `first` and `second`.
     *
     * @param first first vector
     * @param second second vector
     * @return vector sum
     */
    public static Vector sum(Vector first, Vector second) {
        return new Vector(first.getX() + second.getX(), first.getY() + second.getY());
    }

    /**
     * Multiply `this` by `scalar`.
     *
     * @param scalar scalar to multiply by
     */
    public void scale(double scalar) {
        Vector scaled = scaled(this, scalar);
        this.setPoint(scaled.getX(), scaled.getY());
    }

    /**
     * Return the scaled version of `v`, e.g. multiply `v` by `scalar`.
     *
     * @param v vector to scale
     * @param scalar scalar to multiply by
     * @return scaled vector
     */
    public static Vector scaled(Vector v, double scalar) {
        return new Vector(v.getX() * scalar, v.getY() * scalar);
    }

    /**
     * Return the [cross product](https://www.mathsisfun.com/algebra/vectors-cross-product.html)
     * between `this` and `other`. Note that order is important, `this` X `other` is not the same as `other` X `this`.
     *
     * @param other second vector
     * @return cross product `this` X `other`
     */
    public double crossProduct(Vector other) {
        return this.getX() * other.getY() - this.getY() * other.getX();
    }

    /**
     * Return the [dot product](https://www.mathsisfun.com/algebra/vectors-dot-product.html)
     * between `this` and `other`.
     *
     * @param other second vector
     * @return dot product `this` . `other`
     */
    public double dotProduct(Vector other) {
        return this.getX() * other.getX() + this.getY() * other.getY();
    }

    /**
     * Return an inverse of `this`.
     *
     * @return inverse vector
     * */
    public Vector inverse() {
        return new Vector(-this.getX(), -this.getY());
    }

    private void setPoint(double x, double y) {
        this.p.setX(x);
        this.p.setY(y);
        this.length = calculateLength(this.p);
        this.direction = calculateDirection(this.p);
    }

    private static double calculateLength(Point p) {
        return p.distance(new Point(0, 0));
    }

    private static double calculateDirection(Point p) {
        return Math.acos(calculateLength(p) / p.getX());
    }

    private static Point calculatePoint(double length, double direction) {
        return new Point(length * Math.cos(direction), length * Math.sin(direction));
    }
}
