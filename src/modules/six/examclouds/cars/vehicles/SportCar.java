package modules.six.examclouds.cars.vehicles;

import modules.six.examclouds.cars.details.Engine;
import modules.six.examclouds.cars.professions.Driver;

public class SportCar extends Car {
    private double speed;

    public SportCar(String marka, String carClass, double weight, Driver driver, Engine engine, double speed) {
        super(marka, carClass, weight, driver, engine);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return super.toString() + "\nМакс скорость " + speed + " км/ч";
    }
}
