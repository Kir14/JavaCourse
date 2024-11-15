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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
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

        String str;
        switch (count) {
            case 1:
                str = "Одно";
                break;
            case 2:
                str = "Дву";
                break;
            case 3:
                str = "Трех";
                break;
            default:
                str = String.valueOf(count);
        }
        System.out.println("Это " + str + "-значное " + (isPositive ? "положительное" : "отрицательное") + " число");
    }
}
