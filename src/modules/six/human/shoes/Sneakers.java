package modules.six.human.shoes;

public class Sneakers implements IShoes{
    private int size;

    public Sneakers(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void putOn() {
        System.out.println("Надеты кроссовки");
    }

    @Override
    public void takeOff() {
        System.out.println("Сняты кроссовки");
    }

    @Override
    public String toString() {
        return "Кроссовки " + size + " размера";
    }
}
