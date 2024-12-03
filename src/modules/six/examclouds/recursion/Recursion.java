package modules.six.examclouds.recursion;

/*
Даны два целых числа A и В.
Выведите все числа от A до B включительно, в порядке возрастания, если A < B,
или в порядке убывания в противном случае. Использовать рекурсию.
 */

public class Recursion {
    public static void main(String[] args) {
        System.out.println(numbBetween(2, 14));
        System.out.println(numbBetween(45, 34));
    }

    public static String numbBetween(int a, int b) {
        if (a < b - 1) {
            return ++a + "  " + numbBetween(a, b);
        }
        if (b < a - 1) {
            return --a + "  " + numbBetween(a, b);
        }
        return "";
    }
}
