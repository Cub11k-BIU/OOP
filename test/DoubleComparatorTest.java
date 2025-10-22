import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DoubleComparatorTest.
 *
 * @author Konstantin Ostashenko
 * © 2025
 */
class DoubleComparatorTest {

    @Test
    void isEqualTrue() {
        assertTrue(DoubleComparator.isEqual(1.1, 1.1), "Literally equal");
        assertTrue(DoubleComparator.isEqual(2.1, 2.1000000001), "1e-10 positive difference");
        assertTrue(DoubleComparator.isEqual(2.1000000001, 2.1), "1e-10 negative difference");
        assertTrue(DoubleComparator.isEqual(5.0, 4.9999999), "1e-7 positive difference");
        assertTrue(DoubleComparator.isEqual(4.9999999, 5.0), "1e-7 negative difference");

        assertTrue(DoubleComparator.isEqual(-1.1, -1.1), "Literally equal");
        assertTrue(DoubleComparator.isEqual(-2.1, -2.1000000001), "1e-10 positive difference");
        assertTrue(DoubleComparator.isEqual(-2.1000000001, -2.1), "1e-10 negative difference");
        assertTrue(DoubleComparator.isEqual(-5.0, -4.9999999), "1e-7 positive difference");
        assertTrue(DoubleComparator.isEqual(-4.9999999, -5.0), "1e-7 negative difference");
    }

    @Test
    void isEqualFalse() {
        assertFalse(DoubleComparator.isEqual(4.999999, 5.0), "1e-6 positive difference");
        assertFalse(DoubleComparator.isEqual(4.9999990, 5.0), "1e-6 exact positive difference");
        assertFalse(DoubleComparator.isEqual(5.0, 4.999999), "1e-6 negative difference");
        assertFalse(DoubleComparator.isEqual(5.0, 4.9999990), "1e-6 exact negative difference");

        assertFalse(DoubleComparator.isEqual(-4.999999, -5.0), "1e-6 positive difference");
        assertFalse(DoubleComparator.isEqual(-4.9999990, -5.0), "1e-6 exact positive difference");
        assertFalse(DoubleComparator.isEqual(-5.0, -4.999999), "1e-6 negative difference");
        assertFalse(DoubleComparator.isEqual(-5.0, -4.9999990), "1e-6 exact negative difference");

        assertFalse(DoubleComparator.isEqual(3, 5), "Naive big positive difference");
        assertFalse(DoubleComparator.isEqual(5, 3), "Naive big negative difference");

        assertFalse(DoubleComparator.isEqual(-3, -5), "Naive big positive difference");
        assertFalse(DoubleComparator.isEqual(-5, -3), "Naive big negative difference");

    }

    @Test
    void inSegmentTrue() {
        assertTrue(DoubleComparator.inSegment(1.1, 6.345, 1.1), "Literally equal left");
        assertTrue(DoubleComparator.inSegment(1.1, 6.345, 6.345), "Literally equal right");
        assertTrue(DoubleComparator.inSegment(1.1, 6.345, 1.1000001), "1e-7 positive difference left");
        assertTrue(DoubleComparator.inSegment(1.1, 6.345, 1.0999999), "1e-7 negative difference left");
        assertTrue(DoubleComparator.inSegment(1.1, 6.345, 6.3450001), "1e-7 negative difference right");
        assertTrue(DoubleComparator.inSegment(1.1, 6.345, 6.3449999), "1e-7 negative difference right");

        assertTrue(DoubleComparator.inSegment(-1.1, -6.345, -1.1), "Literally equal left");
        assertTrue(DoubleComparator.inSegment(-1.1, -6.345, -6.345), "Literally equal right");
        assertTrue(DoubleComparator.inSegment(-1.1, -6.345, -1.1000001), "1e-7 positive difference left");
        assertTrue(DoubleComparator.inSegment(-1.1, -6.345, -1.0999999), "1e-7 negative difference left");
        assertTrue(DoubleComparator.inSegment(-1.1, -6.345, -6.3450001), "1e-7 negative difference right");
        assertTrue(DoubleComparator.inSegment(-1.1, -6.345, -6.3449999), "1e-7 negative difference right");
    }

    @Test
    void inSegmentFalse() {
        assertFalse(DoubleComparator.inSegment(1.1, 6.345, 1.099999), "1e-6 difference left");
        assertFalse(DoubleComparator.inSegment(1.1, 6.345, 6.345001), "1e-6 difference right");

        assertFalse(DoubleComparator.inSegment(-1.1, -6.345, -1.099999), "1e-6 difference left");
        assertFalse(DoubleComparator.inSegment(-1.1, -6.345, -6.345001), "1e-6 difference right");

        assertFalse(DoubleComparator.inSegment(1.1, 6.345, -3), "Naive big difference left");
        assertFalse(DoubleComparator.inSegment(1.1, 6.345, 105), "Naive big difference right");
    }
}
