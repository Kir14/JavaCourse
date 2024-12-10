package modules.six.human.jacket;

public class LeatherJacket implements IJacket {
    private String material;

    public LeatherJacket(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void putOn() {
        System.out.println("Надета кожаная куртка");
    }

    @Override
    public void takeOff() {
        System.out.println("Снята кожаная куртка");
    }

    @Override
    public String toString() {
        return "Кожаная куртка";
    }
}
