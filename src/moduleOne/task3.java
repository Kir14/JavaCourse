package moduleOne;

import java.util.Scanner;

/*
Дано целое число. Если оно является положительным, то прибавить к нему 1.
 Если отрицательным, то вычесть из него 2. Если нулевым, то заменить его на
 10. Вывести полученное число.
 */
public class task3 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n > 0) {
            n ++;
        } else if (n < 0) {
            n -= 2;
        } else {
            n = 10;
        }
        System.out.println("число = " + n);
    }
}
