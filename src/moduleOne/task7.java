package moduleOne;

import java.util.Scanner;

/*
7) (Дополнительно) В переменную записываете количество программистов. В
 зависимости от количества программистов необходимо вывести правильно
 окончание. Например:
 • 2 программиста
 • 1 программист
 • 10 программистов
 • и т.д
 */
public class task7 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        for (int n = 1; n <= 200; n++) {
            if ((n % 10 == 1) && (n % 100 != 11)) {
                System.out.println(n + " программист");
            }else if((n % 10 < 5) && (n % 10 != 0) && !((n % 100 > 10) && (n % 100 < 15))) {
                System.out.println(n + " программиста");
            } else {
                System.out.println(n + " программистов");
            }
        }

        for (int number = 0; number <= 200; number++) {
            System.out.print(number + " программист");
            if ((number % 10 > 4) || (number % 10 == 0) || ((number % 100 > 10) && (number % 100 < 20))) {
                System.out.print("ов");
            } else if ((number % 10 > 1) && (number % 10 < 5)) {
                System.out.print("а");
            }
            System.out.println();
        }
    }
}
