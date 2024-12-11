package modules.six.human.jacket;

public class Windbreaker implements IJacket {
    private String material;

    public Windbreaker(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void putOn() {
        System.out.println("Надета ветровка");
    }

    @Override
    public void takeOff() {
        System.out.println("Снята ветровка");
    }

    @Override
    public String toString() {
        return "Ветровка";
    }
}
