package modules.six.transport;

import modules.six.transport.air.CivilAviation;
import modules.six.transport.air.MilitaryAviation;
import modules.six.transport.ground.Truck;
import modules.six.transport.ground.Passenger;
import modules.six.transport.ground.TypeCarBody;


public class MainTransport {
    public static void main(String[] args) {
        CivilAviation civilAviation = new CivilAviation(10.25, 32, 1267, 340, 12.5, TypeBrand.Boing, 200, false);
        System.out.println(civilAviation);
        System.out.println();
        System.out.println(civilAviation.canLoadText(205));
        System.out.println(civilAviation.canLoadText(120));
        System.out.println();

        MilitaryAviation militaryAviation = new MilitaryAviation(7.35, 15, 3100, 600, 8, TypeBrand.Boing, true, 2);
        System.out.println(militaryAviation);
        System.out.println();
        System.out.println(militaryAviation.launchRocketText());
        System.out.println(militaryAviation.launchRocketText());
        System.out.println(militaryAviation.launchRocketText());
        System.out.println(militaryAviation.eject());
        System.out.println(militaryAviation.eject());
        System.out.println();

        Truck cargo = new Truck(1.2, 6, 12, 230, 80, 4.5, TypeBrand.МАЗ);
        System.out.println(cargo);
        System.out.println();
        System.out.println(cargo.canLoadText(1.3));
        System.out.println(cargo.canLoadText(1.1));
        System.out.println();

        Passenger passenger = new Passenger(TypeCarBody.Roadster, 2, 4, 15, 230, 220, 2.3, TypeBrand.Audi);
        System.out.println(passenger);
        System.out.println(passenger.getPathLengthByTime(2));
        System.out.println();


    }
}
