import java.awt.*;

import static java.lang.Math.*;

final public class CrossAndZeros {
    int size;
    char[][] table;
    Point del1 = new Point(1, 1);
    Point del2 = new Point(1, -1);
    Point[] delts = {del1, del2};

    public CrossAndZeros(int size) {
        this.size = size;
        this.table = new char[size][size];
    }

    public void addSymbol(char symbol, int line, int column) {
        this.table[line][column] = symbol;
    }

    public void clearCell(int line, int column) {
        this.table[line][column] = '*';
    }

    public int longestLineOrCol(char symbol) {
        int countI = 0, countJ = 0, maxCountI = 0, maxCountJ = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.table[i][j] == symbol) {
                    countI++;
                    if (countI > maxCountI) maxCountI = countI;
                } else countI = 0;
                if (this.table[j][i] == symbol) {
                    countJ++;
                    if (countJ > maxCountJ) maxCountJ = countJ;
                } else countJ = 0;
            }
            countI = 0;
            if (maxCountI == size || maxCountJ == size) break;
        }
        return max(maxCountI, maxCountJ);
    }

    public int longestDiagonal(char symbol) {//Этот цикл про который мы с вами говорили.
        int x = 0, y = 0, i = 0, count = 0, maxCount = 0;
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
        i = 1;//Здесь я перемещаюсь в точку (1;0),чтобы начать оттуда  прохождение по диагоналям до низа(отрабатываю правые диагонали,так как левых нет
        boolean moreHalf = false;//Это используется для того,чтобы вовремя перескочить в точку (1;3)(если для 4клеток),в общем случае для (1,size-1)
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
                y = size - 1;//С этой точки и начинается отработка левых диагоналей до предпослденей клетки низа
                i = 1;//Потом цикл просто break
            }
        }
        return maxCount;
    }

    public void returnTable() {
        for (char[] chars : this.table) {
            for (int j = 0; j < size; j++) {
                if (chars[j] != '0' && chars[j] != 'X') System.out.print('*');
                else System.out.print(chars[j]);
            }
            System.out.print("\n");
        }
    }
}

