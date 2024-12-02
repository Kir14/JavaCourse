package modules.six.examclouds.person;

/*
 переменные fullName, age;
    методы move() и talk(), в которых просто вывести на консоль сообщение -"Такой-то  Person говорит".
    Добавьте два конструктора  - Person() и Person(fullName, age).
    Создайте два объекта этого класса. Один объект инициализируется конструктором Person(), другой - Person(fullName, age).
    Вызовите методы move() и talk().
 */

public class Person {
    private String fullName;
    private int age;

    public Person() {
        fullName = "";
        age = 0;
    }

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

    public void setAge(int age) {
        this.age = age;
    }

    public void move() {
        System.out.println("Move");
    }

    public void talk(String something) {
        System.out.println("Speak :" + something);
    }

    @Override
    public String toString() {
        return "Name: " + fullName + ", age " + age;
    }

}
