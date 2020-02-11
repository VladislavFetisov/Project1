public class Human {
    String street;
    int homeNum;
    int flatNum;

    public Human(String street, int homeNum, int flatNum) {
        this.street = street;
        this.homeNum = homeNum;
        this.flatNum = flatNum;
    }

    public void getAdress() {
        System.out.println("Улица:" + street + " Дом:" + homeNum + " Квартира:" + flatNum);
    }


}
