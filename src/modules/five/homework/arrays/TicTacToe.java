package modules.five.homework.arrays;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int n = 3;
        char[][] matrix = new char[n][n];
        createBoxMatrix(matrix, n);
        outputBoxMatrix(matrix, n);
        Scanner scanner = new Scanner(System.in);
        char c = 'X';
        for (int draw = n*n; draw > 0; draw--) {
            System.out.println("Введите координаты вида: 1a, 2b, 1c, 3a и т.д.");
            System.out.print("Ходит " + c + ": ");
            String coordinate = scanner.nextLine();
            int y = coordinate.charAt(0) - '1';
            int x = coordinate.charAt(1) - 'a';
            if ((x > 2) || (y > 2) || (x < 0) || (y < 0)) {
                System.out.println("Выход за границы диапазона");
                continue;
            }
            if (matrix[x][y] != ' ') {
                System.out.println("Клетка уже занята! Введите другую");
                continue;
            }
            matrix[x][y] = c;
            outputBoxMatrix(matrix, n);
            if (checkWin(matrix, n, x, y, c)) {
                System.out.println("!!!!   Победил  " + c + "   !!!!!!");
                return;
            }
            c = c == 'X' ? 'O' : 'X';
        }
        System.out.println("-------------Ничья-------------");
    }

    private static boolean checkWin(char[][] matrix, int n, int x, int y, char c) {
        //check row
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[x][i] == c)
                count++;
        }
        if (count == 3)
            return true;
        //check column
        count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][y] == c)
                count++;
        }
        if (count == 3)
            return true;
        //check main diag
        if (x == y) {
            count = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][i] == c)
                    count++;
            }
            if (count == 3)
                return true;
        }
        //check second diag
        if (x == (n - 1 - y)) {
            count = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][n - 1 - i] == c)
                    count++;
            }
            if (count == 3)
                return true;
        }
        return false;
    }

    public static void createBoxMatrix(char[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    public static void outputBoxMatrix(char[][] matrix, int n) {
        System.out.println(" 1 2 3 ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("|" + matrix[i][j]);
            }
            System.out.println("| " + (char) ('a' + i));
        }
    }
}
