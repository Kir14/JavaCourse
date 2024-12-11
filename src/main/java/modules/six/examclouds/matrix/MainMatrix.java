package modules.six.examclouds.matrix;

public class MainMatrix {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 3);
        createMatrix(m1);
        System.out.println("----m1-----");
        System.out.println(m1);

        Matrix m2 = new Matrix(3, 3);
        createMatrix(m2);
        System.out.println("----m2-----");
        System.out.println(m2);

        System.out.println("----m1+m2-----");
        m1.plusMatrix(m2);
        System.out.println(m1);

        System.out.println("----m2*2-----");
        m2.multiply(2);
        System.out.println(m2);

        Matrix m3 = new Matrix(2,3);
        createMatrix(m3);
        System.out.println("----m3-----");
        System.out.println(m3);
        Matrix m4 = new Matrix(3,2);
        createMatrix(m4);
        System.out.println("----m4-----");
        System.out.println(m4);
        Matrix m5 = m3.multiplyMatrix(m4);
        System.out.println("----m3*m4-----");
        System.out.println(m5);
    }

    public static void createMatrix(Matrix m) {
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                m.set(i, j, (int) (Math.random() * 10));
            }
        }
    }
}
