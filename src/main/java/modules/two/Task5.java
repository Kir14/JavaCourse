package modules.two;

/*
Напишите программу печати таблицы перевода расстояний из дюймов в
 сантиметры для значений длин от 1 до 20 дюймов. 1 дюйм = 2,54 см
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println("| inch |  cm  |");
        for (int i = 1; i < 21; i++) {
            System.out.println("|" + String.format("%-6s", i) + "|" + String.format("%6s", i * 2.54) + "|");
        }
    }
}
