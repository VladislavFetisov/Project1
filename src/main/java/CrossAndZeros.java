import static java.lang.Math.*;

public class CrossAndZeros {
    int size;
    char[][] table;

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

        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
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
            if (maxCountI == this.table.length || maxCountJ == this.table.length) break;
        }
        return max(maxCountI, maxCountJ);
    }

    //public int longestDiagonal(char symbol) { }

    public void returnTable() {
        for (char[] chars : this.table) {
            for (int j = 0; j < this.table.length; j++) {
                if (chars[j] != '0' && chars[j] != 'X') System.out.print('*');
                else System.out.print(chars[j]);
            }
            System.out.print("\n");
        }
    }

}

