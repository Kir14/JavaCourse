package modules.six.examclouds.person;

public class MainPerson {
    public static void main(String[] args) {
        Person ivan = new Person();
        ivan.setAge(45);
        ivan.setFullName("Ivan");

        Person oleg = new Person("Oleg", 23);

        oleg.move();
        ivan.talk("Hello");

        System.out.println(ivan);
        System.out.println(oleg);
    }
}
