package modules.six.examclouds.matrix;

public class Matrix {
    private int[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
    }

    public int get(int i, int j) {
        return matrix[i][j];
    }

    public void set(int i, int j, int number) {
        matrix[i][j] = number;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //сложение с другой матрицей;
    public boolean plusMatrix(Matrix b) {
        if ((rows != b.getRows()) || (columns != b.getColumns())) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] += b.matrix[i][j];
            }
        }
        return true;
    }

    //умножение на число;
    public void multiply(int a) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] *= a;
            }
        }
    }

    //умножение матриц
    public Matrix multiplyMatrix(Matrix b) {
        Matrix result = new Matrix(rows, b.getColumns());
        for (int i = 0; i < rows; i++) {
            for (int column = 0; column < b.columns; column++) {
                int sum = 0;
                for (int j = 0; j < columns; j++) {
                    sum += matrix[i][j] * b.matrix[j][column];
                }
                result.matrix[i][column] = sum;
            }
        }
        return result;
    }

    //вывод на печать;
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(String.format("%3s", matrix[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
