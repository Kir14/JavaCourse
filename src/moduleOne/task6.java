package moduleOne;

import java.util.Scanner;

/*
Даны 2 числа. Вывести большее из них.
 */
public class task6 {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(a > b ? a : b);
        System.out.println(Math.max(a, b));
        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
