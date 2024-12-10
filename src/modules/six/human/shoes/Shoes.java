package modules.six.human.shoes;

public class Shoes implements IShoes {
    private int size;

    public Shoes(int size) {
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
        System.out.println("Надеты туфли");
    }

    @Override
    public void takeOff() {
        System.out.println("Сняты туфли");
    }

    @Override
    public String toString() {
        return "Туфли " + size + " размера";
    }
}
