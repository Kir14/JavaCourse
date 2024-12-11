package modules.six.examclouds.shapes;

public class MainShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(Color.RED, 2,4,1);
        shapes[1] = new Rectangle(Color.YELLOW, 2, -1, 3, 4);

        for(Shape sh : shapes) {
            sh.draw();
        }

    }
}
