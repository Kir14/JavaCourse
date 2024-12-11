package modules.six.examclouds.animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Гав-гав");
    }

    @Override
    public void eat() {
        System.out.println("Кость норм");
    }

    @Override
    public String getDescription() {
        return "Собака по кличке " + getName();
    }
}
