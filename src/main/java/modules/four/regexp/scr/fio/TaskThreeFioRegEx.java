package modules.four.regexp.scr.fio;

import java.util.Scanner;

/*
Измените программу, написанную в уроке №4: вводимая строка с фамилией, именем и отчеством
должна разбиваться с использованием регулярного выражения.
 */
public class TaskThreeFioRegEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client(scanner.nextLine());
        System.out.println(client);
    }
}
