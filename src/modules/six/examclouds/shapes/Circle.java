package modules.six.examclouds.shapes;

public class Circle extends Shape {

    private int x;
    private int y;
    private int radius;

    public Circle(Color color) {
        super(color);
        x = 0;
        y = 0;
        radius = 0;
    }

    public Circle(Color color, int x, int y, int radius) {
        super(color);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем " + getColor() + " круг в точке (" + x + ", " + y + ") и радиусом " + radius);
    }
}
