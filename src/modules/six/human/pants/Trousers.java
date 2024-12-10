package modules.six.human.pants;

public class Trousers implements IPants {
    private int size;

    public Trousers(int size) {
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
        System.out.println("Надеты брюки");
    }

    @Override
    public void takeOff() {
        System.out.println("Сняты брюки");
    }

    @Override
    public String toString() {
        return "Брюки " + size + " размера";
    }
}
