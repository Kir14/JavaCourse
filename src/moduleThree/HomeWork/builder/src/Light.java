package moduleThree.HomeWork.builder.src;

public class Light {

    private boolean turnOn;

    public void turnOn() {
        turnOn = true;
    }

    public void turnOff() {
        turnOn = false;
    }

    public boolean isTurnOn() {
        return  turnOn;
    }

}
