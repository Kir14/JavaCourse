package modules.five.list.todolist;

/*
Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
Принцип работы команд:
•	LIST — выводит дела с их порядковыми номерами;
•	ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
•	EDIT — заменяет дело с указанным номером;
•	DELETE — удаляет.
 */

import java.util.Scanner;

public class MainToDo {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command:");
            String line = scanner.nextLine().trim() + " ";
            int spaceIndex = line.indexOf(' ');
            String command = line.substring(0, spaceIndex);
            int secondSpaceIndex;
            String digit;
            switch (command) {
                case "LIST":
                    if (!line.equals("LIST ")) {
                        System.out.println("LIST doesn't have any arguments");
                        break;
                    }
                    System.out.print(list);
                    break;
                case "ADD":
                    if (line.equals("ADD ")) {
                        System.out.println("ADD needs arguments");
                        break;
                    }
                    secondSpaceIndex = line.indexOf(' ', spaceIndex + 1);
                    digit = line.substring(spaceIndex + 1, secondSpaceIndex);
                    if (digit.matches("\\d+")) {
                        if (!list.addItem(line.substring(secondSpaceIndex + 1, line.length() - 1), Integer.parseInt(digit))) {
                            System.out.println("Out of range");
                        }
                    } else {
                        list.addItem(line.substring(spaceIndex + 1, line.length() - 1));
                    }
                    break;
                case "EDIT":
                    if (!line.matches("EDIT \\d+ .+")) {
                        System.out.println("EDIT needs arguments: EDIT index text");
                        break;
                    }
                    secondSpaceIndex = line.indexOf(' ', spaceIndex + 1);
                    digit = line.substring(spaceIndex + 1, secondSpaceIndex);
                    if (digit.matches("\\d+")) {
                        if (!list.editItem(line.substring(secondSpaceIndex + 1, line.length() - 1), Integer.parseInt(digit))) {
                            System.out.println("Out of range");
                        }
                    } else {
                        System.out.println("There is no index");
                    }
                    break;
                case "DELETE":
                    if (!line.matches("DELETE \\d+")) {
                        System.out.println("EDIT needs arguments: DELETE index");
                        break;
                    }
                    secondSpaceIndex = line.indexOf(' ', spaceIndex + 1);
                    digit = line.substring(spaceIndex + 1, secondSpaceIndex);
                    if (digit.matches("\\d+")) {
                        if (!list.deleteItem(Integer.parseInt(digit))) {
                            System.out.println("Out of range");
                        }
                    } else {
                        System.out.println("There is no index");
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
