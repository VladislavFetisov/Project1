public class Main {
    public static void main(String[] args) {
        CrossAndZeros as=new CrossAndZeros(4);
        as.addSymbol('0',0,0);
        as.addSymbol('0',2,1);
        as.addSymbol('0',1,3);



        as.returnTable();
        System.out.println(as.longestDiagonal('X'));
        System.out.println(as.longestLineOrCol('0'));
    }
}
