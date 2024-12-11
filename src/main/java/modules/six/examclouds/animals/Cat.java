package modules.six.examclouds.animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Мау-мяу");
    }

    @Override
    public void eat() {
        System.out.println("Ем только ВИСКАААААС!!!!");
    }

    @Override
    public String getDescription() {
        return "Котик " + getName();
    }
}
