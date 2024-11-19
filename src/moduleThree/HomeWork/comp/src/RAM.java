package moduleThree.HomeWork.comp.src;

public class RAM {
    private int volume;

    public RAM(int volume) {
        this.volume = volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Оперативка объем " + volume;
    }
}
