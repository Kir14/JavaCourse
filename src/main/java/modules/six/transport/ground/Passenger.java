package modules.six.transport.ground;

/*
В классе Легковой добавляются поля: - -
Тип кузова
Кол-во пассажиров
 */

import modules.six.transport.Transport;
import modules.six.transport.TypeBrand;

public class Passenger extends GroundTransport {

    private TypeCarBody carBody;
    private int countPassengers;


    public Passenger(TypeCarBody carBody, int countPassengers, int countWheels, double fuelCons, int power, int maxSpeed, double weight, TypeBrand brand) {
        super(countWheels, fuelCons, power, maxSpeed, weight, brand);
        this.carBody = carBody;
        this.countPassengers = countPassengers;
    }

    public TypeCarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(TypeCarBody carBody) {
        this.carBody = carBody;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public String getPathLengthByTime(double time) {
        return "За время " + time + " ч, автомобиль " + super.getBrand()
                + " двигаясь с максимальной скоростью " + super.getMaxSpeed() + " км/ч"
                + " проедет " + (super.getMaxSpeed() * time) + " км  и израсходует " + calculateFuel(time) + " литров топлива.";
    }

    private double calculateFuel(double time) {
        return ((super.getMaxSpeed() * time)) * super.getFuelCons() / 100;
    }


    @Override
    public String toString() {
        return "Легковой автомобиль " + super.getBrand() + " массой " + super.getWeight() + " т, макс скорость " + super.getMaxSpeed() + " км/ч"
                + "\nРасход на 100 км " + super.getFuelCons() + " л, кол-во колес " + super.getCountWheels()
                + "\nТип кузова " + carBody + ", количество пассажиров " + countPassengers
                + "\nМощность " + super.getPower() + " л.с Или " + (Transport.KOEF_HP_KV * super.getPower()) + " кВ";
    }
}
