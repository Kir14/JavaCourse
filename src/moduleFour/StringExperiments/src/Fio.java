package moduleFour.StringExperiments.src;

import java.util.Scanner;

/*
Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
(например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
 */
public class Fio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.trim();
        line += " ";
        int spaceIndex = line.indexOf(' ');
        if (spaceIndex != -1) {
            System.out.println("Фамилия: " + line.substring(0, spaceIndex));
            line = line.substring(spaceIndex + 1);
        }
        spaceIndex = line.indexOf(' ', spaceIndex);
        if (spaceIndex != -1) {
            System.out.println("Имя: " + line.substring(0, spaceIndex));
            line = line.substring(spaceIndex + 1);
        }
        spaceIndex = line.indexOf(' ', spaceIndex);
        if (spaceIndex != -1) {
            System.out.println("Отчество: " + line.substring(0, spaceIndex));
        }
    }
}
