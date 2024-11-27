package modules.five.set.treeset;

/*
Что нужно сделать
1.	Напишите программу, в которой будет храниться перечень адресов электронной почты. Адреса можно добавлять через консоль командой ADD и печатать весь список командой LIST.
2.	Программа должна проверять корректность вводимых email’ов и печатать сообщение об ошибке при необходимости.
Принцип работы команд
•	LIST — выводит список электронных адресов.
•	ADD — проверяет и, если формат адреса верный, добавляет в множество.
 */

import java.util.Scanner;

public class MainEmails {
    public static void main(String[] args) {
        EmailsSet emails = new EmailsSet();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command:");
            String[] line = scanner.nextLine().split("\\s");
            switch (line[0]) {
                case "LIST":
                    System.out.print(emails);
                    break;
                case "ADD":
                    if (!emails.addEmail(line[1])) {
                        System.out.println("Wrong format");
                    }
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("The command was not recognized");

            }
        }
    }
}
