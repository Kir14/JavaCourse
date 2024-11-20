package modules.three.homework.builder.src;

public class Light {

    private boolean turnOn;
    private final int powerWatts;

    public Light(int powerWatts){
        turnOn = false;
        this.powerWatts = powerWatts;
    }

    public void turnOn() {
        turnOn = true;
    }

    public void turnOff() {
        turnOn = false;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    public int getPowerWatts() {
        return powerWatts;
    }

    @Override
    public String toString() {
        return "Лампочка " + powerWatts + " Вт" + (turnOn ? " включена" : " выключена");
    }

}
