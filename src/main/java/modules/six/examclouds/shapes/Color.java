package modules.six.examclouds.shapes;

public enum Color {
    RED("красный"),
    YELLOW("желтый"),
    BLACK("черный"),
    WHITE("белый");


    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
}
