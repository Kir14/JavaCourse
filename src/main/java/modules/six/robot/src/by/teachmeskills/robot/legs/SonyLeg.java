package modules.six.robot.src.by.teachmeskills.robot.legs;


public class SonyLeg implements ILeg {
    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    public SonyLeg() {
    }

    @Override
    public void step() {
        System.out.println("Нога Sony делает шаг");
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Нога Sony " + getPrice();
    }
}