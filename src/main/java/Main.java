public class Main {
    public static void main(String[] args) {
        CrossAndZeros as=new CrossAndZeros(3);
        as.addSymbol('0',0,0);
        as.addSymbol('0',2,1);
        as.addSymbol('0',1,2);
        as.returnTable();
        System.out.println(as.longestDiagonal('0'));
        System.out.println(as.longestLineOrCol('0'));

    }
}
