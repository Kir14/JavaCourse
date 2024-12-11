package modules.six.examclouds.cars.professions;

/*
Класс Driver содержит поля - ФИО, стаж вождения.
 */
public class Driver extends Person {

    private int experience;

    public Driver(String fullName, int age, int experience) {
        super(fullName, age);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString() + ", стаж вождения " + experience;
    }
}
