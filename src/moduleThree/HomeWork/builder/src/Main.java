package moduleThree.HomeWork.builder.src;

public class Main {
    public static void main(String[] args) {

        Appartment appartment1 = new Appartment(32);
        Appartment appartment2 = new Appartment(565);;

        appartment1.setLight(new Light());
        appartment1.setDoor(new Door());

        appartment2.setLight(new Light());
        appartment2.setDoor(new Door());

        System.out.println(appartment1);
        System.out.println(appartment2);


        System.out.println(appartment1);
        System.out.println(appartment2);



    }
}
