import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exersice1 = " + exersice1() + " км");

        System.out.println("Exersice2 ");
        exersice2();

        System.out.println("Exersice3 = " + exersice3());

        System.out.println("Exersice4");
        System.out.println("a*b= " + exersice4());

        System.out.println("Exersice5");
        exersice5();
    }

    public static double exersice1() {
        double start = 10;
        double sum = 0;
        double interest = 0.10;
        int days = 7;
        for (int i = 0; i < days; i++) {
            sum += start;
            start *= (1 + interest);
        }
        return sum;
    }

    public static void exersice2() {
        int time = 3;
        int start = 1;
        int countOfDivisions = 2;
        for (int i = 3; i < 25; i += time) {
            start *= countOfDivisions;
            System.out.println("Time " + i + " count of ameb = " + start);
        }
    }

    public static int exersice3() {
        int start = 1;
        int sum = 0;
        while (start < 257) {
            sum += start;
            start *= 2;
        }
        return sum;
    }

    public static int exersice4() {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        int sum = 0;
        while (b > 0) {
            sum += a;
            b--;
        }
        return sum;
    }

    public static void exersice5() {
        System.out.println("| inch |  cm  |");
        for (int i = 1; i < 21; i++) {
            System.out.println("|" + String.format("%-6s", i) + "|" + String.format("%6s", i * 2.54) + "|");
        }
    }
}