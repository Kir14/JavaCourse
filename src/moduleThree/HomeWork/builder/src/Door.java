package moduleThree.HomeWork.builder.src;

public class Door {

    private boolean open;
    private final TypeMaterial material;

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

    public String getStringMaterial() {
        switch (material) {
            case WOODEN:
                return "деревянная";
            case METAL:
                return "металлическая";
            case PLASTIC:
                return "пластиковая";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "Дверь " + getStringMaterial() + (open ? " открыта" : " закрыта");
    }
}
