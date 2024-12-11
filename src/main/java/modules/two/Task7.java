package modules.two;

/*
Напишите программу, определяющую сумму всех нечетных чисел от 1
до 99
 */
public class Task7 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        sum = 0;
        for (int i = 1; i < 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println((1 + 99) / 2 * 50);
    }
}
