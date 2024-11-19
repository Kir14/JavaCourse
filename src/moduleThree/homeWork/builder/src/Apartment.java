package moduleThree.homeWork.builder.src;

public class Apartment {

    private int number;
    private Window window;
    private Light light;
    private Door door;

    public Apartment() {
        number = 0;
    }

    public Apartment(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        return "Квартира № " + number +
                (door != null ? "\n" + door : "") +
                (window != null ? "\n" + window : "") +
                (light != null ? "\n" + light : "");
    }

}
