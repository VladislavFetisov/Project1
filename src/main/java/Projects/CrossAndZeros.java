package Projects;

import java.util.Arrays;
import java.util.Objects;

import static Projects.Symbol.Null;

public class CrossAndZeros {

    private int size;
    private Symbol[][] table;
    private Point del1 = new Point(1, 1);
    private Point del2 = new Point(1, -1);
    private Point[] delts = {del1, del2};

    public CrossAndZeros(int size) {
        if (size <= 0) throw new IllegalArgumentException("Введите размер поля больше 0!");
        this.size = size;
        this.table = new Symbol[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = Null;
            }
        }
    }

    public boolean addSymbol(Symbol symbol, int line, int column) {
        if (symbol == Null) throw new IllegalArgumentException("Добавлять возможно только X или O!");
        if (table[line][column] == Null) {
            table[line][column] = symbol;
            return true;
        } else System.out.println("Клетка занята,выберете другую");
        return false;
    }

    public boolean clearCell(int line, int column) {
        if (table[line][column] == Null) {
            System.out.println("Клетка уже пустая");
            return false;
        } else table[line][column] = Null;
        return true;
    }

    public int longestLine(Symbol symbol) {
        int countI = 0, countJ = 0, maxCount = 0, count = 0, x = 0, y = 0, i = 0;

        for (int k = 0; k < size; k++) {
            for (int j = 0; j < size; j++) {
                if (table[k][j] == symbol) {
                    countI++;
                    if (countI > maxCount) maxCount = countI;
                } else countI = 0;
                if (table[j][k] == symbol) {
                    countJ++;
                    if (countJ > maxCount) maxCount = countJ;
                } else countJ = 0;
            }
            countJ = 0;
            countI = 0;
        }
        while (i != size) {
            for (Point delt : delts) {
                while (x >= 0 && x < size && y >= 0 && y < size) {
                    if (table[x][y] == symbol) count++;
                    else count = 0;
                    if (count > maxCount) maxCount = count;
                    x += delt.x;
                    y += delt.y;
                }
                count = 0;
                x = 0;
                y = i;
            }
            y++;
            i++;
        }
        x = 1;
        y = 0;
        i = 1;
        boolean moreHalf = false;
        while (i != size - 1) {
            Point delt;
            if (moreHalf) delt = del2;
            else delt = del1;
            while (x >= 0 && x < size && y >= 0 && y < size) {
                if (table[x][y] == symbol) count++;
                else count = 0;
                if (count > maxCount) maxCount = count;
                x += delt.x;
                y += delt.y;
            }
            count = 0;
            if (moreHalf) y = size - 1;
            else y = 0;
            x = i;
            x++;
            i++;
            if (i == size - 1) {
                if (moreHalf) break;
                else moreHalf = true;
                x = 1;
                y = size - 1;
                i = 1;
            }
        }
        return maxCount;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        for (Symbol[] symbols : this.table) {
            for (int j = 0; j < size; j++) {
                if (symbols[j] == Null) a.append('*');
                else a.append(symbols[j]);
            }
            a.append(System.lineSeparator());
        }
        return a.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrossAndZeros that = (CrossAndZeros) o;
        return Arrays.deepEquals(table, that.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }
}

