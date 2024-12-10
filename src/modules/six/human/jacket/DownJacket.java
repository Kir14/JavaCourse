package modules.six.human.jacket;

public class DownJacket implements IJacket {
    private String material;

    public DownJacket(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void putOn() {
        System.out.println("Надет пуховик");
    }

    @Override
    public void takeOff() {
        System.out.println("Снят пуховик");
    }

    @Override
    public String toString() {
        return "Пуховик";
    }
}
