package modules.six.transport.ground;

/*
В классе Грузовой добавляется  поле:  -
Грузоподъёмность(т)
 */

import modules.six.transport.Transport;
import modules.six.transport.TypeBrand;

public class Truck extends GroundTransport {

    private double loadCapacity;

    public Truck(double loadCapacity, int countWheels, double fuelCons, int power, int maxSpeed, double weight, TypeBrand brand) {
        super(countWheels, fuelCons, power, maxSpeed, weight, brand);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean canLoad(double cargo) {
        return cargo <= loadCapacity;
    }

    public String canLoadText(double cargo) {
        return canLoad(cargo) ? "Грузовик загружен" : "Вам нужен грузовик побольше";
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль " + super.getBrand() + " массой " + super.getWeight() + " т, макс скорость " + super.getMaxSpeed() + " км/ч"
                + "\nРасход на 100 км" + super.getFuelCons() + " л, кол-во колес " + super.getCountWheels()
                + "\nГрузоподъемность " + loadCapacity + " т"
                + "\nМощность " + super.getPower() + " л.с Или " + (Transport.KOEF_HP_KV * super.getPower()) + " кВ";
    }
}
