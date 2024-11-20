package modules.four.experiments.string.src.stringEx;

import java.util.Scanner;

/*
Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
(например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
 */
public class Fio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client(scanner.nextLine());
        System.out.println(client);
    }
}
