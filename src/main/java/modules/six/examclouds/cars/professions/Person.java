package modules.six.examclouds.cars.professions;

public class Person {
    private String fullName;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void serAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullName + " " + age + " лет";
    }
}
