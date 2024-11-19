package moduleThree.homeWork.builder.src;

public class Builder {
    public static void main(String[] args) {
        Apartment apartment1 = new Apartment(456);

        apartment1.setLight(new Light(40));
        apartment1.setDoor(new Door(TypeMaterial.METAL));

        apartment1.getDoor().open();

        System.out.println(apartment1);

        Apartment apartment2 = new Apartment(15);

        apartment2.setLight(new Light(60));
        apartment2.setWindow(new Window());

        apartment2.getLight().turnOn();

        System.out.println(apartment2);

    }
}
