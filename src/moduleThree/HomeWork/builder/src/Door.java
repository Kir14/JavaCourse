package moduleThree.HomeWork.builder.src;

public class Door {

    private boolean open;
    private TypeMaterial material;

    public Door(TypeMaterial material) {
        open = false;
        this.material = material;
    }

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public TypeMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TypeMaterial material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Дверь " + material + (open ? " открыта" : " закрыта");
    }
}
