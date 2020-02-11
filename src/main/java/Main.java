import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CrossAndZeros as=new CrossAndZeros(3);
        as.addSymbol('0',2,2);
        System.out.println(Arrays.deepToString(as.table));
        as.clearCell(2,2);
        System.out.println(Arrays.deepToString(as.table));
    }
}
