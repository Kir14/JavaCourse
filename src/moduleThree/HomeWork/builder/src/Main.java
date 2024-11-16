package moduleThree.HomeWork.builder.src;

public class Main {
    public static void main(String[] args) {
        Builder oleg = new Builder("Олег");
        Builder.Appartment appartment1 = oleg.buildApartment(23);
        Builder.Appartment appartment2 = oleg.buildApartment(54);

        System.out.println(appartment1);
        System.out.println(appartment2);

        oleg.openDoor();
        oleg.setAppartment(appartment1);
        oleg.turnOnLight();

        System.out.println(appartment1);
        System.out.println(appartment2);



    }
}
