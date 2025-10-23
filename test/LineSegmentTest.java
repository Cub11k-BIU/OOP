import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LineSegmentTest.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
class LineSegmentTest {

    @Test
    void getP1() {
        Point p = new Point(0, 0);
        LineSegment l = new LineSegment(p, new Point(1, 1));
        assertTrue(l.getP1().isEqual(p));
        assertNotEquals(p, l.getP1(), "Encapsulation in constructor");
        l.getP1().setX(1);
        assertTrue(l.getP1().isEqual(p), "Encapsulation in getter");
    }

    @Test
    void getP2() {
        Point p = new Point(4.567, 8.90123);
        LineSegment l = new LineSegment(new Point(1.1111, 1.435678), p);
        assertTrue(l.getP2().isEqual(p));
        assertNotEquals(p, l.getP2(), "Encapsulation in constructor");
        l.getP2().setX(1);
        assertTrue(l.getP2().isEqual(p), "Encapsulation in getter");
    }

    @Test
    void setP1() {
        LineSegment l = new LineSegment(new Point(1.1111, 1.435678), new Point(1, 1));
        Point p = new Point(0, 0);
        l.setP1(p);
        assertTrue(p.isEqual(l.getP1()));
        p.setX(1);
        assertFalse(p.isEqual(l.getP1()), "Encapsulation in setter");
        assertTrue(DoubleComparator.isEqual(0, l.getP1().getX()), "Encapsulation in setter");
    }

    @Test
    void setP2() {
        LineSegment l = new LineSegment(new Point(1.1111, 1.435678), new Point(1, 1));
        Point p = new Point(0, 0);
        l.setP2(p);
        assertTrue(p.isEqual(l.getP2()));
        p.setX(1);
        assertFalse(p.isEqual(l.getP2()), "Encapsulation in setter");
        assertTrue(DoubleComparator.isEqual(0, l.getP2().getX()), "Encapsulation in setter");
    }

    @Test
    void length() {
        LineSegment l = new LineSegment(new Point(0, 0), new Point(0, 1));
        assertTrue(DoubleComparator.isEqual(1, l.length()));
        l = new LineSegment(new Point(12.345, 6.789), new Point(-6.789, -12.345));
        assertTrue(DoubleComparator.isEqual(27.0595623, l.length()));
    }

    @Test
    void middle() {
        Random rand = new Random();
        double x = rand.nextDouble();
        double y = rand.nextDouble();
        Point p = new Point(x, y);
        LineSegment l = new LineSegment(p, p);
        assertTrue(p.isEqual(l.middle()));

        LineSegment l2 = new LineSegment(new Point(2356.234, 987.965), new Point(10.245, 10.245));
        assertTrue(new Point(1183.2395, 499.105).isEqual(l2.middle()));
    }

    @Test
    void isEqualTrue() {
        LineSegment l = new LineSegment(new Point(1, 2), new Point(3, 4));
        LineSegment l2 = new LineSegment(new Point(3, 4), new Point(1, 2));
        assertTrue(l.isEqual(l), "Self");
        assertTrue(l.isEqual(new LineSegment(l.getP1(), l.getP2())), "Default constructor");
        assertTrue(new LineSegment(l.getP1(), l.getP2()).isEqual(l), "Default constructor: symmetry");
        assertTrue(l.isEqual(l2), "Direction-agnostic");
        assertTrue(l2.isEqual(l), "Direction-agnostic: symmetry");
    }

    @Test
    void isEqualFalse() {
        Point p = new Point(1, 2);
        Point px = new Point(1.00001, 2);
        Point py = new Point(1, 2.00001);
        Point q = new Point(3, 4);
        Point qx = new Point(3.00001, 4);
        Point qy = new Point(3, 4.00001);
        Point r = new Point(5, 6);
        LineSegment l = new LineSegment(p, q);
        assertFalse(l.isEqual(new LineSegment(p, r)), "Naive");
        assertFalse(l.isEqual(new LineSegment(px, q)), "Difference: p1.x");
        assertFalse(l.isEqual(new LineSegment(py, q)), "Difference: p1.y");
        assertFalse(l.isEqual(new LineSegment(p, qx)), "Difference: p2.x");
        assertFalse(l.isEqual(new LineSegment(p, qy)), "Difference: p2.y");
    }

    @Test
    void contains() {
        /* Wrapper method, only test consistency!
         * The actual result (belongs or not) does not matter at all, we only test the fact that LineSegment.contains is
         * consistently equal to PointSegmentIntersection.intersects
         */
        Random rand = new Random();
        int iterations = 100;
        int cnt = 0;
        for (int i = 0; i < iterations; i++) {
            Point p = new Point(rand.nextDouble(), rand.nextDouble());
            Point q = new Point(rand.nextDouble(), rand.nextDouble());
            Point r = new Point(rand.nextDouble(), rand.nextDouble());
            LineSegment l = new LineSegment(p, q);
            if (l.contains(p) == PointSegmentIntersection.intersects(p, l)) {
                cnt++;
            }
        }
        assertEquals(iterations, cnt, "Consistency percentage: " + cnt + "/" + iterations);
    }
}