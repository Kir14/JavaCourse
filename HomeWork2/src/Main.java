public class Main {
    public static void main(String[] args) {
        System.out.println("Exersice1 = " + exersice1() + " км");

        System.out.println("Exersice2 ");
        exersice2();

        System.out.println("Exersice3 = " + exersice3());
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
        for (int i = 3; i < 25; i+=time) {
            start *= countOfDivisions;
            System.out.println("Time " + i + " count of ameb = " + start);
        }
    }

    public static int exersice3() {
        int start = 1;
        int sum = 0;
        while(start < 257){
            sum += start;
            start *= 2;
        }
        return sum;
    }
}