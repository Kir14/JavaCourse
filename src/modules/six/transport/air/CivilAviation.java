package modules.six.transport.air;

/*
В классе Гражданский добавляются поля:
- Кол-во пассажиров
- Наличие бизнес класса (true/fals
 */

import modules.six.transport.Transport;
import modules.six.transport.TypeBrand;

public class CivilAviation extends AirTransport {

    private int countPassengers;
    private boolean businessClass;

    public CivilAviation(double wingspan, double minLengthRoad, int power, int maxSpeed, double weight, TypeBrand brand, int countPassengers, boolean businessClass) {
        super(wingspan, minLengthRoad, power, maxSpeed, weight, brand);
        this.countPassengers = countPassengers;
        this.businessClass = businessClass;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public boolean hasBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        this.businessClass = businessClass;
    }

    public boolean canLoad(int passengers) {
        return passengers <= countPassengers;
    }

    public String canLoadText(int passengers) {
        return canLoad(passengers) ? "Самолет загружен" : "Вам нужен самолет побольше";
    }

    @Override
    public String toString() {
        return "Гражданская авиация " + super.getBrand() + " массой " + super.getWeight() + " т, макс скорость " + super.getMaxSpeed() + " км/ч"
                + "\nРазмах крыльев " + super.getWingspan() + " м, мин взлетная полоса " + super.getMinLengthRoad() + " м"
                + "\nКоличество пассажиров " + countPassengers + (businessClass ? ", присутствуют" : ", отсутствуют") + "места бизнес класса"
                + "\nМощность " + super.getPower() + " л.с Или " + (Transport.KOEF_HP_KV * super.getPower()) + " кВ";
    }
}
