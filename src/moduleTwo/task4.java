package moduleTwo;

import java.util.Scanner;

/*
Составьте программу, вычисляющую A*B, не пользуясь операцией
умножения.
 */
public class task4 {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        int sum = 0;
        while (b > 0) {
            sum += a;
            b--;
        }
        System.out.println(sum);
    }
}
