package modules.six.examclouds.shapes;

public class Rectangle extends Shape {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(Color color) {
        super(color);
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем " + getColor() + " прямоугольник в точке (" + x + ", " + y + ") и размером " + width + " х " + height);
    }
}
