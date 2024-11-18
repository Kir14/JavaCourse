package moduleThree.HomeWork.builder.src;

public class Window {

    private boolean open;

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public String toString() {
        return "Окно " + (open ? "открыто" : "закрыто");
    }

}
