/**
 * Vector.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Vector {
    /**
     * Constructor.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Vector(double x, double y) {
    }

    /**
     * Return the `x` coordinate of this vector.
     *
     * @return coordinate x
     */
    public double getX() {
        return 0;
    }

    /**
     * Return the `y` coordinate of this vector.
     *
     * @return coordinate y
     */
    public double getY() {
        return 0;
    }

    /**
     * Return the length of this vector.
     *
     * @return length
     */
    public double getLength() {
        return 0;
    }

    /**
     * Return the direction of this vector represented as a signed angle
     * in radians(not degrees) between this vector and positive axis X.
     *
     * @return direction
     */
    public double getDirection() {
        return 0;
    }

    /**
     * Assign the `x` coordinate of this vector.
     *
     * @param x coordinate x
     */
    public void setX(double x) {
    }

    /**
     * Assign the `y` coordinate of this vector.
     *
     * @param y coordinate y
     */
    public void setY(double y) {
    }

    /**
     * Assign the length of this vector, don't forget to preserve the direction.
     *
     * @param length length
     */
    public void setLength(double length) {
    }

    /**
     * Assign the direction of this vector, don't forget to preserve the length.
     *
     * @param direction direction (angle in radians)
     */
    public void setDirection(double direction) {
    }

    /**
     * Return the coordinates representation of this vector.
     *
     * @return point
     */
    public Point coordinates() {
        return null;
    }

    /**
     * Return `true` if `this` represents the same equivalence class as `other`.
     *
     * @param other vector to compare against
     * @return `true` if `this` and `other` are the same vector mathematically, `false` otherwise.
     */
    public boolean isEqual(Vector other) {
        return false;
    }

    /**
     * Return the vector sum of `this` and `other`.
     *
     * @param other vector to add
     * @return vector sum
     */
    public Vector add(Vector other) {
        return null;
    }

    /**
     * Return the vector sum of `first` and `second`.
     *
     * @param first first vector
     * @param second second vector
     * @return vector sum
     */
    public static Vector sum(Vector first, Vector second) {
        return null;
    }

    /**
     * Return the scaled version of `this`, e.g. multiply `this` by `scalar`.
     *
     * @param scalar scalar to multiply by
     * @return scaled vector
     */
    public Vector scale(double scalar) {
        return null;
    }

    /**
     * Return the cross product between `this` and `other`.
     * Note that order is important, `this` X `other` is not the same as `other` X `this`.
     *
     * @param other second vector
     * @return cross product `this` X `other`
     */
    public double crossProduct(Vector other) {
        return 0;
    }

    /**
     * Return the dot product between `this` and `other`.
     *
     * @param other second vector
     * @return dot product `this` . `other`
     */
    public double dotProduct(Vector other) {
        return 0;
    }
}
