package Projects;

import static Projects.Symbol.O;

public class Main {
    public static void main(String[] args) {
        CrossAndZeros asd = new CrossAndZeros(3);
        asd.addSymbol(O,1,1);
        CrossAndZeros asa= new CrossAndZeros(3);
        asa.addSymbol(O,1,1);
        System.out.println(asd.equals(asa));

    }
}
