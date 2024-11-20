package modules.two;

import java.util.Scanner;

/*
Составьте программу, вычисляющую A*B, не пользуясь операцией
умножения.
 */
public class Task4 {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        System.out.println("way one:");
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        System.out.println(sum);
        System.out.println("way two:");
        sum = 0;
        for (; b > 0; b--) {
            sum += a;
        }
        System.out.println(sum);
    }
}
