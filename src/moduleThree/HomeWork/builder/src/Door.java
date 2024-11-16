package moduleThree.HomeWork.builder.src;

public class Door {

    private boolean open;

    public void openDoor() {
        open = true;
    }

    public void closeDoor() {
        open = false;
    }

    public boolean isOpen() {
        return  open;
    }

}
