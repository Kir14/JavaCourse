package modules.one;

import java.util.Scanner;

/*
Даны 3 целых числа. Найти количество положительных и отрицательных
 чисел в исходном наборе.
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPositive = 0;
        int countNegative = 0;
        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();
            if (n > 0) {
                countPositive++;
            } else if (n < 0) {
                countNegative++;
            }
        }
        System.out.println("Количество положительных = " + countPositive);
        System.out.println("Количество отрицательных = " + countNegative);
    }
}
