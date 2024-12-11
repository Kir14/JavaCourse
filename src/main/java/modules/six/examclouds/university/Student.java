package modules.six.examclouds.university;

/*
Класс Student содержит переменные: String firstName, lastName, group. А также, double averageMark, содержащую среднюю оценку.
 */

public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private double averageMark;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        group = "";
        averageMark = 0;
    }

    public Student(String firstName, String lastName, String group) {
        this(firstName, lastName);
        this.group = group;
        averageMark = 0;
    }

    public Student(String firstName, String lastName, String group, double averageMark) {
        this(firstName, lastName, group);
        this.averageMark = averageMark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLatName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    /*
    Создать метод getScholarship() для класса Student, который возвращает сумму стипендии.
    Если средняя оценка студента равна 5, то сумма 2000 грн, иначе 1900.
     */
    public double getScholarship() {
        return averageMark == 5 ? 2000 : 1900;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + group + " avg mark: " + averageMark;
    }

}
