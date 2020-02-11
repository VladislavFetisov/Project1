public class CrossAndZeros {
    int size;
    char[][] table;

    public CrossAndZeros(int size) {
        this.size = size;
        this.table = new char[size][size];
    }

    public void addSymbol(char symbol, int column, int line) {
        this.table[column][line] = symbol;
    }

    public void clearCell(int column, int line) {
        this.table[column][line] = ' ';
    }
}
