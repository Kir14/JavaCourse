package modules.six.transport.ground;

/*
В классе Наземный добавляются поля:
 -Количество колёс
 - Расход топлива(л/100км)
 */

import modules.six.transport.Transport;
import modules.six.transport.TypeBrand;

public class GroundTransport extends Transport {

    private int countWheels;
    private double fuelCons;

    public GroundTransport(int countWheels, double fuelCons, int power, int maxSpeed, double weight, TypeBrand brand) {
        super(power, maxSpeed, weight, brand);
        this.countWheels = countWheels;
        this.fuelCons = fuelCons;
    }

    public int getCountWheels() {
        return countWheels;
    }

    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }

    public double getFuelCons() {
        return fuelCons;
    }

    public void setFuelCons(double fuelCons) {
        this.fuelCons = fuelCons;
    }
}
