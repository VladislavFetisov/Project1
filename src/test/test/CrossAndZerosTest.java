import Project1.CrossAndZeros;
import org.junit.jupiter.api.Test;

import static Project1.Symbol.*;
import static org.junit.jupiter.api.Assertions.*;

class CrossAndZerosTest {

    @Test
    void addSymbol() {
        CrossAndZeros asd = new CrossAndZeros(4);
        assertTrue(asd.addSymbol(O, 2, 3));
        assertFalse(asd.addSymbol(O, 2, 3));
        assertFalse(asd.addSymbol(X, 2, 3));
        try {
            assertTrue(asd.addSymbol(Null, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            assertTrue(asd.addSymbol(X, -1, -1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void clearCell() {
        CrossAndZeros test = new CrossAndZeros(4);
        test.addSymbol(X, 3, 3);
        assertTrue(test.clearCell(3, 3));
        assertFalse(test.clearCell(3, 2));
        try {
            assertTrue(test.clearCell(-1, 5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void longestLine() {
        CrossAndZeros test = new CrossAndZeros(4);
        test.addSymbol(O, 0, 1);
        test.addSymbol(X, 0, 2);
        test.addSymbol(X, 1, 1);
        test.addSymbol(O, 1, 2);
        test.addSymbol(O, 1, 3);
        test.addSymbol(O, 2, 0);
        test.addSymbol(X, 2, 1);
        test.addSymbol(X, 2, 2);
        test.addSymbol(O, 3, 0);
        test.addSymbol(X, 3, 3);
        test.addSymbol(O, 0, 0);
        test.addSymbol(O, 1, 0);
        System.out.println(test.toString());
        assertEquals(3, test.longestLine(X));
        assertEquals(4, test.longestLine(O));
    }

    @Test
    void equals() {
        CrossAndZeros a = new CrossAndZeros(4);
        CrossAndZeros b = new CrossAndZeros(4);
        b.addSymbol(O, 1, 1);
        a.addSymbol(X, 1, 1);
        assertNotEquals(a, b);
        a.clearCell(1, 1);
        a.addSymbol(O, 1, 1);
        assertEquals(a, b);
    }

    @Test
    void CrossAndZeros() {
        try {
            CrossAndZeros a = new CrossAndZeros(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void HashCode() {
        CrossAndZeros test = new CrossAndZeros(4);
        CrossAndZeros test1 = new CrossAndZeros(4);
        assertEquals(test.hashCode(), test1.hashCode());
        test1.addSymbol(O,1,1);
        assertNotEquals(test.hashCode(),test1.hashCode());
    }
}