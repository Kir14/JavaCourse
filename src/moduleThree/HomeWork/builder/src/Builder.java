package moduleThree.HomeWork.builder.src;

public class Builder {

    private String name;
    private Appartment appartment;

    public void turnOnLight() {
        Light light = appartment.getLight();
        if (light != null) {
            light.turnOn();
        }
    }

    public void turnOffLight() {
        Light light = appartment.getLight();
        if (light != null) {
            light.turnOn();
        }
    }

    public void openDoor() {
        Door door = appartment.getDoor();
        if (door != null) {
            door.openDoor();
        }
    }

    public void closeDoor() {
        Door door = appartment.getDoor();
        if (door != null) {
            door.closeDoor();
        }
    }

    public Builder(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAppartment(Appartment appartment) {
        this.appartment = appartment;
    }

    public Appartment getAppartment() {
        return appartment;
    }

    public Appartment buildApartment(int number) {
        appartment = new Appartment(number);
        System.out.println("Хорошая работа " + name);
        return appartment;
    }
}
