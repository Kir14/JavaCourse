package modules.six.human.pants;

public class Jeans implements IPants {

    private int size;

    public Jeans(int size) {
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
        System.out.println("Надеты джинсы");
    }

    @Override
    public void takeOff() {
        System.out.println("Сняты джинсы");
    }

    @Override
    public String toString() {
        return "Джинсы " + size + " размера";
    }
}
