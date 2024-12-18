package modules.seven.exception.homework;

import java.util.ArrayList;

public class CarMain {
    public static void main(String[] args) {
        Car bugatti = new Car();
        bugatti.setModel("Bugatti");
        bugatti.setSpeed(320);
        bugatti.setPrice(213431);

        Car ferrari = new Car("Ferrari", 320, 4327298.87);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(bugatti);
        cars.add(ferrari);

        cars.add(new Car("Lada", 120, 431));
        cars.add(new Car("Lada X Ray", 130, 651));


        for (Car car : cars) {
            try {
                car.start();
                System.out.println(car.getModel() + " завелась");
            } catch (CarException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
