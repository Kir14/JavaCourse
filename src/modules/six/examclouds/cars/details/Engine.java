package modules.six.examclouds.cars.details;

/*
Класс Engine содержит поля - мощность, производитель.
 */
public class Engine {
    private int power;
    private String company;

    public Engine(int power, String company) {
        this.power = power;
        this.company = company;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Мотор мощность " + power + " л.с. от " + company;
    }
}
