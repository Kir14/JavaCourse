package modules.one;

import java.util.Scanner;

/*
Даны 3 целых числа. Найти количество положительных чисел в исходном
 наборе
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();
            if (n > 0) {
                count++;
            }
        }
        System.out.println("Количество положительных = " + count);
    }
}
