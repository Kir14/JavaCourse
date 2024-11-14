package moduleOne;

import java.util.Scanner;

/*
Треугольник существует только тогда, когда сумма любых двух его сторон
 больше третьей. Определить существует ли такой треугольник. Дано: a, b, c
стороны предполагаемого треугольника. Требуется сравнить длину каждого
 отрезка-стороны с суммой двух других. Если хотя бы в одном случае отрезок
 окажется больше суммы двух других, то треугольника с такими сторонами не
 существует
 */
public class task2 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сторона 1 =");
        a = scanner.nextInt();
        System.out.print("Сторона 2 =");
        b = scanner.nextInt();
        System.out.print("Сторона 3 =");
        c = scanner.nextInt();
        if ((a + b > c) && (a + c > b) && (b + c > c)) {
            System.out.println("Есть");
        } else {
            System.out.println("Ну нет");
        }
    }
}
