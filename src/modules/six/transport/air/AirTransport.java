package modules.six.transport.air;

/*
В классе Воздушный добавляются поля:
- Размах крыльев (м)
- Минимальная длина взлётно-посадочной полосы для взлёта
 */

import modules.six.transport.Transport;
import modules.six.transport.TypeBrand;

public class AirTransport extends Transport {

    private double wingspan;
    private double minLengthRoad;

    public AirTransport(double wingspan, double minLengthRoad, int power, int maxSpeed, double weight, TypeBrand brand) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minLengthRoad = minLengthRoad;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double getMinLengthRoad() {
        return minLengthRoad;
    }

    public void setMinLengthRoad(double minLengthRoad) {
        this.minLengthRoad = minLengthRoad;
    }
}
