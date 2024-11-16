package moduleThree.HomeWork.builder.src;

public class Main {
    public static void main(String[] args) {
        Builder oleg = new Builder("Олег");
        Appartment appartment1 = oleg.buildApartment(23);
        Appartment appartment2 = oleg.buildApartment(54);

        appartment1.setLight(new Light());
        appartment1.setDoor(new Door());

        appartment2.setLight(new Light());
        appartment2.setDoor(new Door());

        System.out.println(appartment1);
        System.out.println(appartment2);

        oleg.openDoor();
        oleg.setAppartment(appartment1);
        oleg.turnOnLight();

        System.out.println(appartment1);
        System.out.println(appartment2);



    }
}
