package moduleOne;

import java.util.Scanner;

/*
В переменную записываем число. Надо вывести на экран сколько в этом
 числе цифр и положительное оно или отрицательное. Например, "это
 однозначное положительное число". Достаточно будет определить, является ли
 число однозначным, "двухзначным или трехзначным и более
 */
public class task1 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n == 0) {
            System.out.println("Ну это 0");
            return;
        }
        boolean isPositive = (n > 0);
        n = Math.abs(n);
        int count = 1;
        while (n > 10) {
            n /= 10;
            count++;
        }

        System.out.println("Это " + count + "-значное " + (isPositive ? "положительное" : "отрицательное") + " число");
    }
}
