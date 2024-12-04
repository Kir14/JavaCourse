package modules.six.examclouds.store;

public enum TypeCategory {
    TECH("Technic"),
    FRUIT("Fruits"),
    VEG("Vegetables");

    private String nameCategory;

    TypeCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    @Override
    public String toString() {
        return nameCategory;
    }
}
