/**
 * SegmentSegmentIntersection.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
public class SegmentSegmentIntersection {
    private LineSegment intersectionSegment;

    /**
     * Constructor.
     *
     * @param first  first line segment
     * @param second second line segment
     */
    public SegmentSegmentIntersection(LineSegment first, LineSegment second) {
        Point p1 = first.getP1();
        Point p2 = first.getP2();
        Point q1 = second.getP1();
        Point q2 = second.getP2();

        Vector p = new Vector(p1.getX(), p1.getY());
        Vector r = new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY());
        Vector q = new Vector(q1.getX(), q1.getY());
        Vector s = new Vector(q2.getX() - q1.getX(), q2.getY() - q1.getY());

        Vector qDiffP = Vector.sum(q, p.inverse());
        double qDiffPCrossR = qDiffP.crossProduct(r);
        double rCrossS = r.crossProduct(s);

        if (DoubleComparator.isEqual(rCrossS, 0.0)) {
            if (DoubleComparator.isEqual(qDiffPCrossR, 0.0)) {

                double dP1 = 0.0;
                double dP2 = r.dotProduct(r);
                double dQ1 = qDiffP.dotProduct(r);
                Vector qsDiffP = Vector.sum(Vector.sum(q, s), p.inverse());
                double dQ2 = qsDiffP.dotProduct(r);
                if (dQ1 > dQ2) {
                    double temp = dQ1;
                    dQ1 = dQ2;
                    dQ2 = temp;
                }
                double tStart = Math.max(dP1, dQ1);
                double tEnd = Math.min(dP2, dQ2);
                if (tStart <= tEnd) {
                    Point start = Vector.sum(p, Vector.scaled(r, tStart / dP2)).coordinates();
                    Point end = Vector.sum(p, Vector.scaled(r, tEnd / dP2)).coordinates();
                    this.intersectionSegment = new LineSegment(start, end);
                }
            }
            double qDiffPCrossS = qDiffP.crossProduct(s);
            double t = qDiffPCrossS / rCrossS;
            double u = qDiffPCrossR / rCrossS;
            if (0 <= t && t <= 1 && 0 <= u && u <= 1) {
                Point intersection = Vector.sum(p, Vector.scaled(r, t)).coordinates();
                this.intersectionSegment = new LineSegment(intersection, intersection);
            }
            this.intersectionSegment = null;
        }
    }

    /**
     * Determine whether two line segments intersect.
     *
     * @return `true` if there is an intersection, `false` otherwise.
     */
    public boolean intersects() {
        return intersectionSegment != null;
    }

    /**
     * Find the intersection segment between `first` and `second`.
     *
     * @return intersection line segment
     */
    public LineSegment intersectionSegment() {
        if (!this.intersects()) {
            return null;
        }
        return new LineSegment(this.intersectionSegment.getP1(), this.intersectionSegment.getP2());
    }
}
