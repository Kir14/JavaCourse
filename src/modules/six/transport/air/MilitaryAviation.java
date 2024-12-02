package modules.six.transport.air;

/*
В классе Военный  добавляются поля: - -
Наличие системы катапультирования (true/false)
Кол-во ракет на борту
 */

import modules.six.transport.Transport;
import modules.six.transport.TypeBrand;

public class MilitaryAviation extends AirTransport {

    private boolean ejectSystem;
    private int countRockets;

    public MilitaryAviation(double wingspan, double minLengthRoad, int power, int maxSpeed, double weight, TypeBrand brand, boolean ejectSystem, int countRockets) {
        super(wingspan, minLengthRoad, power, maxSpeed, weight, brand);
        this.ejectSystem = ejectSystem;
        this.countRockets = countRockets;
    }

    public boolean hasEjectSystem() {
        return ejectSystem;
    }

    public void setEjectSystem(boolean ejectSystem) {
        this.ejectSystem = ejectSystem;
    }

    public int getCountRockets() {
        return countRockets;
    }

    public void setCountRockets(int countRockets) {
        this.countRockets = countRockets;
    }

    public boolean launchRocket() {
        if (countRockets > 0) {
            countRockets--;
            return true;
        }
        return false;
    }

    public String launchRocketText() {
        return launchRocket() ? "Ракета пошла…" : "Боеприпасы отсутствуют";
    }

    public String eject() {
        if (ejectSystem) {
            ejectSystem = false;
            return "Катапультирование прошло успешно";
        } else {
            return "У вас нет такой системы";
        }
    }


    @Override
    public String toString() {
        return "Военная авиация " + super.getBrand() + " массой " + super.getWeight() + " т, макс скорость " + super.getMaxSpeed() + " км/ч "
                + "\nРазмах крыльев " + super.getWingspan() + " м, мин взлетная полоса " + super.getMinLengthRoad() + " м"
                + "\nКоличество ракет " + countRockets + (ejectSystem ? ", оборудован" : ", не оборудован") + " системой катапультирования"
                + "\nМощность " + super.getPower() + " л.с Или " + (Transport.KOEF_HP_KV * super.getPower()) + " кВ";
    }
}
