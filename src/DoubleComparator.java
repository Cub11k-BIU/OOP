/**
 * DoubleComparator.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class DoubleComparator {

    /**
     * Determine whether two doubles are equal.
     *
     * @param first  first number
     * @param second second number
     * @return `true` if first equals second, `false` otherwise
     */
    public static boolean isEqual(double first, double second) {
        double eps = 1e-6;
        return Math.abs(first - second) < eps;
    }

    /**
     * Determine whether a <= value <= b.
     *
     * @param a     left edge
     * @param b     right edge
     * @param value value to check
     * @return `true` if a <= value <= b, `false` otherwise
     */
    public static boolean inSegment(double a, double b, double value) {
        if (b < a) {
            double tmp = a;
            a = b;
            b = tmp;
        }
        return isEqual(value, a) || (a < value && value < b) || isEqual(value, b);
    }
}
