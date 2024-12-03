package modules.six.examclouds.animals;

public class Bear extends Animal {

    public Bear(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Звуки медведя");
    }

    @Override
    public void eat() {
        System.out.println("Мёд only");
    }

    @Override
    public String getDescription() {
        return "Здоровый мишка " + getName();
    }
}
