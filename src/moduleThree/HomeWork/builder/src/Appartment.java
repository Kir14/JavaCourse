package moduleThree.HomeWork.builder.src;

public class Appartment {

    private int number;
    private Window window;
    private Light light;
    private Door door;

    public Appartment() {
        number = 0;
    }

    public Appartment(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public Light getLight() {
        return light;
    }

    @Override
    public String toString() {
        return "\nКвартира № " + number + "\nДверь " + (door.isOpen() ? "открыта" : "закрыта") +
                "\nОкно " + (window.isOpen() ? "открыто" : "закрыто") +
                "\nСвет " + (light.isTurnOn() ? "включен" : "выключен");
    }

}
