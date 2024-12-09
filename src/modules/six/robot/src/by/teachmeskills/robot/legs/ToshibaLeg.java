package modules.six.robot.src.by.teachmeskills.robot.legs;

public class ToshibaLeg implements ILeg {
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    public ToshibaLeg() {
    }

    @Override
    public void step() {
        System.out.println("Нога Samsung делает шаг");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
