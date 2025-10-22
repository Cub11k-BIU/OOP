/**
 * PointSegmentIntersection.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class PointSegmentIntersection {
    /**
     * Point-segment intersection algorithm.
     *
     * @param p point
     * @param l segment
     * @return `true` if `p` belongs to line segment `l`, `false` otherwise
     */
    public static boolean intersects(Point p, LineSegment l) {
        /*
         * Why move intersection algorithm into a separate class?
         * Indeed, we can just calculate the same inside Point.belongsTo or LineSegment.contains.
         * Why not do it? The answer is testing! We would like to test Point and LineSegment completely separately.
         * If we implement this algorithm in Point.belongsTo, we have to assume all methods of LineSegment to be valid
         * during testing of Point.
         * If we implement this algorithm in LineSegment.contains, we have to assume all methods of Point to be valid
         * during testing of LineSegment.
         * Solution is clear - make both Point.belongsTo and Line.contains wrappers and implement the algorithm
         * somewhere else!
         * */
        Point p1 = l.getP1();
        Point p2 = l.getP2();
        double yDiff = p1.getY() - p2.getY();
        double xDiff = p1.getX() - p2.getX();
        if (DoubleComparator.isEqual(xDiff, 0.0)) {
            return DoubleComparator.isEqual(p.getX(), p1.getX())
                    && DoubleComparator.inSegment(p1.getY(), p2.getY(), p.getY());
        }
        double k = yDiff / xDiff;
        double b = p1.getY() - k * p1.getX();
        return DoubleComparator.inSegment(p1.getX(), p2.getX(), p.getX())
                && DoubleComparator.isEqual(p.getY(), k * p.getX() + b);
    }
}
