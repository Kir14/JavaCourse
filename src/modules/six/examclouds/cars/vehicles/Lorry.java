package modules.six.examclouds.cars.vehicles;

import modules.six.examclouds.cars.details.Engine;
import modules.six.examclouds.cars.professions.Driver;

public class Lorry extends Car {

    private int carrying;

    public Lorry(String marka, String carClass, double weight, Driver driver, Engine engine, int carrying) {
        super(marka, carClass, weight, driver, engine);
        this.carrying = carrying;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    @Override
    public String toString() {
        return super.toString() + "\nГрузоподъемность " + carrying + " т";
    }
}
