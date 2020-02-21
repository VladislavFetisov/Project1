import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrossAndZerosTest {

    @Test
    void addSymbol() {
    }

    @Test
    void clearCell() {
    }

    @Test
    void longestLineOrCol() {
        CrossAndZeros test = new CrossAndZeros(4);
        test.addSymbol('0', 0, 0);
        test.addSymbol('0', 0, 1);
        test.addSymbol('0', 1, 0);
        test.addSymbol('0', 1, 1);
        test.addSymbol('0', 2, 1);
        test.addSymbol('0', 2, 2);
        test.addSymbol('0', 3, 2);
        test.addSymbol('0', 3, 3);
        test.addSymbol('X', 0, 3);
        test.addSymbol('X', 1, 3);
        assertEquals(3,test.longestLineOrCol('0'));
        assertEquals(2,test.longestLineOrCol('X'));
        test.returnTable();
    }

    @Test
    void longestDiagonal() {
        CrossAndZeros test = new CrossAndZeros(4);
        test.addSymbol('0', 0, 0);
        test.addSymbol('0', 0, 3);
        test.addSymbol('0', 1, 1);
        test.addSymbol('0', 1, 2);
        test.addSymbol('X', 1, 3);
        test.addSymbol('0', 2, 1);
        test.addSymbol('X', 2, 2);
        test.addSymbol('0', 3, 0);
        test.addSymbol('0', 3, 3);
        test.addSymbol('X', 3, 1);
        assertEquals(4,test.longestDiagonal('0'));
        assertEquals(3,test.longestDiagonal('X'));
        test.returnTable();
    }
}