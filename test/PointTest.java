import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PointTest.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
class PointTest {

    @Test
    void getX() {
        Point p = new Point(1.8, 2);
        assertTrue(DoubleComparator.isEqual(1.8, p.getX()));
        p = new Point(134.21, 22);
        assertTrue(DoubleComparator.isEqual(134.21, p.getX()));
    }

    @Test
    void getY() {
        Point p = new Point(-3, -8.002);
        assertTrue(DoubleComparator.isEqual(-8.002, p.getY()));
        p = new Point(3, 0.4443);
        assertTrue(DoubleComparator.isEqual(0.4443, p.getY()));
    }

    @Test
    void setX() {
        Point p = new Point(0, 0);
        double x = new Random().nextDouble();
        p.setX(x);
        assertTrue(DoubleComparator.isEqual(x, p.getX()));
        assertTrue(DoubleComparator.isEqual(0, p.getY()));
    }

    @Test
    void setY() {
        Point p = new Point(0, 0);
        double y = new Random().nextDouble();
        p.setY(y);
        assertTrue(DoubleComparator.isEqual(0, p.getX()));
        assertTrue(DoubleComparator.isEqual(y, p.getY()));
    }

    @Test
    void distance() {
        Point p = new Point(0, 0);
        Point q = new Point(3, 4);
        assertTrue(DoubleComparator.isEqual(5, p.distance(q)), "Integers: literal");
        assertTrue(DoubleComparator.isEqual(p.distance(q), p.distance(q)), "Integers: consistency");
        assertTrue(DoubleComparator.isEqual(p.distance(q), q.distance(p)), "Integers: symmetry");
        q = new Point(12.345, 6.789);
        assertTrue(DoubleComparator.isEqual(14.0886318, p.distance(q)), "Doubles: literal");
        assertTrue(DoubleComparator.isEqual(p.distance(q), p.distance(q)), "Doubles: consistency");
        assertTrue(DoubleComparator.isEqual(p.distance(q), q.distance(p)), "Doubles: symmetry");
    }

    @Test
    void isEqualTrue() {
        Random rand = new Random();
        double x = rand.nextDouble();
        double y = rand.nextDouble();
        Point p = new Point(x, y);
        assertTrue(p.isEqual(p), "Self");
        assertTrue(p.isEqual(new Point(x, y)), "Default constructor");
        assertTrue(new Point(x, y).isEqual(p), "Default constructor: symmetry");
    }

    @Test
    void isEqualFalse() {
        Random rand = new Random();
        double x = rand.nextDouble();
        double y = rand.nextDouble();
        Point p = new Point(x, y);
        assertFalse(p.isEqual(new Point(x + 0.00001, y)), "Difference: x");
        assertFalse(p.isEqual(new Point(x, y + 0.00001)), "Difference: y");
        assertFalse(p.isEqual(new Point(x + 0.00001, y + 0.00001)), "Difference: x, y");
    }

    @Test
    void belongsTo() {
        /* Wrapper method, only test consistency!
         * The actual result (belongs or not) does not matter at all, we only test the fact that Point.belongsTo is
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
            if (p.belongsTo(l) == PointSegmentIntersection.intersects(p, l)) {
                cnt++;
            }
        }
        assertEquals(iterations, cnt, "Consistency percentage: " + cnt + "/" + iterations);
    }
}