package moduleOne;

import java.util.Scanner;

/*
7) (Дополнительно) В переменную записываете количество программистов. В
 зависимости от количества программистов необходимо вывести правильно
 окончание. Например:
 • 2 программиста
 • 1 программиста
 • 10 программистов
 • и т.д
 */
public class task7 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if ((n % 10 < 5) && (n % 10 != 0) && !((n > 10) && (n < 15))) {
            System.out.println(n + " программиста");
        } else {
            System.out.println(n + " программистов");
        }
    }
}
