package modules.six.examclouds.cars;

import modules.six.examclouds.cars.details.Engine;
import modules.six.examclouds.cars.professions.Driver;
import modules.six.examclouds.cars.vehicles.Lorry;
import modules.six.examclouds.cars.vehicles.SportCar;

public class MainCar {
    public static void main(String[] args) {
        Engine vEight = new Engine(800, "Ford");
        Driver oleg = new Driver("oleg", 45, 44);
        SportCar ferrari = new SportCar("Ferrari", "sport", 2.3, oleg, vEight, 320);
        Lorry truck = new Lorry("BELAZ", "truck", 10, oleg, vEight, 5);

        System.out.println(ferrari);
        System.out.println();
        System.out.println(truck);

        ferrari.start();
        ferrari.turnLeft();
        ferrari.turnRight();
        ferrari.stop();
    }
}
