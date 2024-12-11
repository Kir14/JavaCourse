package modules.six.transport;

/*
В классе Транспорт есть поля: - - - -
Мощность(в лошадиных силах)
Максимальная скорость(км/ч)
Масса (кг)
Марка( например: Audi, BMW , Boing,  Airbus,  Scania , МАЗ и т.д. )
 */

public class Transport {
    private int power;
    private int maxSpeed;
    private double weight;
    private TypeBrand brand;

    public final static double KOEF_HP_KV = 0.74;

    public Transport(int power, int maxSpeed, double weight, TypeBrand brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.brand = brand;
        this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public TypeBrand getBrand() {
        return brand;
    }

    public void setBrand(TypeBrand brand) {
        this.brand = brand;
    }
}
