package modules.five.map;

/*
1. Напишите программу, которая будет работать как телефонная книга:
•	Если пишем новое имя, программа просит ввести номер телефона и запоминает его. Если новый номер телефона — просит ввести имя и также запоминает.
•	Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
•	При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
2. Определяйте имя и телефон с помощью регулярных выражений.
3. Подумайте, что выбрать в качестве ключа и значения для Map, выберите лучший вариант по вашему мнению. Опишите, какие минусы и плюсы видите в вашем выборе.

 */

import java.util.Scanner;

public class MainPhonebook {
    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Enter Name, Phone or 'LIST'");
            String line = scanner.nextLine();
            if (line.equals("LIST")) {
                System.out.print(phonebook);
                continue;
            }
            if (PhoneBook.isPhone(line)) {
                if (phonebook.containsPhone(line)) {
                    System.out.println(phonebook.getName(line));
                } else {
                    System.out.println("Enter name: ");
                    phonebook.put(scanner.nextLine(), line);
                }
            } else if (PhoneBook.isName(line)) {
                if (phonebook.containsName(line)) {
                    System.out.println(phonebook.getPhone(line));

                } else {
                    System.out.println("Enter phone:");
                    phonebook.put(line, scanner.nextLine());
                }
            } else {
                System.out.println("You entered something neponyatnoe");
            }
        }

    }
}
