import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PointSegmentIntersectionTest.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
class PointSegmentIntersectionTest {

    @Test
    void intersectsTrue() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 1);
        Point r = new Point(-3, -3);
        assertTrue(PointSegmentIntersection.intersects(p, new LineSegment(p, p)), "Degenerate segment");
        assertTrue(PointSegmentIntersection.intersects(p, new LineSegment(p, q)), "First end-point");
        assertTrue(PointSegmentIntersection.intersects(p, new LineSegment(q, p)), "Second end-point");
        assertTrue(PointSegmentIntersection.intersects(p, new LineSegment(q, r)), "Naive");
        assertTrue(PointSegmentIntersection.intersects(p, new LineSegment(r, q)), "Naive: symmetry");

        Point p1 = new Point(23.45678, 1.023);
        LineSegment l1 = new LineSegment(new Point(123.3490, 45.00001), new Point(-4.57, -11.3156384));
        LineSegment l2 = new LineSegment(new Point(-4.57, -11.3156384), new Point(123.3490, 45.00001));
        assertTrue(PointSegmentIntersection.intersects(p1, l1), "Precision");
        assertTrue(PointSegmentIntersection.intersects(p1, l2), "Precision: symmetry");
    }

    @Test
    void intersectsFalse() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 1);
        Point r = new Point(-3, -5);
        assertFalse(PointSegmentIntersection.intersects(p, new LineSegment(q, r)), "Naive");
        assertFalse(PointSegmentIntersection.intersects(p, new LineSegment(r, q)), "Naive: symmetry");

        Point p1 = new Point(23.45678, 1.023);
        LineSegment l1 = new LineSegment(new Point(123.3490, 45.00001), new Point(-4.57, -11.315637));
        LineSegment l2 = new LineSegment(new Point(-4.57, -11.315637), new Point(123.3490, 45.00001));
        assertFalse(PointSegmentIntersection.intersects(p1, l1), "Precision");
        assertFalse(PointSegmentIntersection.intersects(p1, l2), "Precision: symmetry");
    }
}