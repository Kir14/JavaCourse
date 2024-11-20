package modules.two;

/*
Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
сколько амеб будет через 3, 6, 9, 12,..., 24 часа.
 */
public class Task2 {
    public static void main(String[] args) {
        int time = 3;
        int start = 1;
        int countOfDivisions = 2;
        for (int i = 3; i < 25; i += time) {
            start *= countOfDivisions;
            System.out.println("Time " + i + " count of ameb = " + start);
        }
    }
}
