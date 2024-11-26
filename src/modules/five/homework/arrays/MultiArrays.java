package modules.five.homework.arrays;

import java.util.Scanner;

public class MultiArrays {
    public static void main(String[] args) {
        int n;
        //n = getSize();
        n = 4;
        int[][] matrix = new int[n][n];
        createBoxMatrix(matrix, n);
        outputBoxMatrix(matrix, n);

        /*
        1) Почитать сумму четных элементов стоящих на главной диагонали.
        */
        int sumMainDiag = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] % 2 == 0)
                sumMainDiag += matrix[i][i];
        }
        System.out.println("сумма четных элементов стоящих на главной диагонали = " + sumMainDiag);

        /*
         2)Вывести нечетные элементы находящиеся под главной
        диагональю(включительно).
        */
        System.out.print("нечетные элементы находящиеся под главной диагональю(включительно): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (matrix[i][j] % 2 == 1) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();

        /*
         3)Проверить произведение элементов какой диагонали больше.
         */
        int compMain = 1;
        int compSec = 1;
        for (int i = 0; i < n; i++) {
            compMain *= matrix[i][i];
            compSec *= matrix[i][n - 1 - i];
        }
        if (compMain > compSec) {
            System.out.println("произведение элементов главной диагонали больше (" + compMain + " > " + compSec + ")");
        } else {
            System.out.println("произведение элементов побочной диагонали больше (" + compSec + " > " + compMain + ")");
        }

        /*
         4)Посчитать сумму четных элементов стоящих над побочной диагональю (не
        включительно)
        */
        int sumEvenSec = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - 1 - i); j++) {
                if (matrix[i][j] % 2 == 0) {
                    sumEvenSec += matrix[i][j];
                }
            }
        }
        System.out.println("сумма четных элементов стоящих над побочной диагональю (не включительно) = " + sumEvenSec);

        /*
         5)Транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й
        строкой и т. д.)
         */
        System.out.println("----Оригинал------");
        outputBoxMatrix(matrix, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("------После транспонировки-----");
        outputBoxMatrix(matrix, n);

    }


    /*
     Начало всех задач:
     Создаём квадратную матрицу, размер вводим с клавиатуры. Заполняем
    случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде
    матрицы)
     */
    public static void createBoxMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 51);
            }
        }
    }

    public static void outputBoxMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3s", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int getSize() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
