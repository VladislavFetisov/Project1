import Projects.CrossAndZeros;
import org.junit.jupiter.api.Test;

import static Projects.Symbol.*;
import static org.junit.jupiter.api.Assertions.*;

class CrossAndZerosTest {

    @Test
    void addSymbol() {
        CrossAndZeros asd = new CrossAndZeros(4);
        assertTrue(asd.addSymbol(O, 2, 3));
        assertFalse(asd.addSymbol(O, 2, 3));
        assertFalse(asd.addSymbol(X, 2, 3));
    }

    @Test
    void clearCell() {
        CrossAndZeros test = new CrossAndZeros(4);
        test.addSymbol(X, 3, 3);
        assertTrue(test.clearCell(3, 3));
        assertFalse(test.clearCell(3, 2));
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
        assertEquals(3,test.longestLine(X));
        assertEquals(4,test.longestLine(O));
    }
}