package modules.three.homework.builder.src;

public enum TypeMaterial {
    WOODEN("деревянная"),
    PLASTIC("пластиковая"),
    METAL("металлическая");

    private String material;

    TypeMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return material;
    }
}
