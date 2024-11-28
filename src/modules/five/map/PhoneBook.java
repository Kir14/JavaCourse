package modules.five.map;

/*
1. Напишите программу, которая будет работать как телефонная книга:
•	Если пишем новое имя, программа просит ввести номер телефона и запоминает его. Если новый номер телефона — просит ввести имя и также запоминает.
•	Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
•	При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
2. Определяйте имя и телефон с помощью регулярных выражений.
3. Подумайте, что выбрать в качестве ключа и значения для Map, выберите лучший вариант по вашему мнению. Опишите, какие минусы и плюсы видите в вашем выборе.

 */

import java.util.TreeMap;

public class PhoneBook {
    private TreeMap<String, String> phonebook;

    public PhoneBook() {
        phonebook = new TreeMap<>();
    }

    public static boolean isPhone(String line) {
        return line.matches("\\d+");
    }

    public static boolean isName(String line) {
        return line.matches("[A-Za-z]+");
    }

    public boolean containsPhone(String phone) {
        return phonebook.containsValue(phone);
    }

    public boolean containsName(String name) {
        return phonebook.containsKey(name);
    }

    public String getPhone(String name) {
        return phonebook.get(name);
    }

    public void put(String name, String phone) {
        phonebook.put(name, phone);
    }

    public String getName(String phone) {
        for (String name : phonebook.keySet()) {
            if (phone.equals(phonebook.get(name))) {
                return name;
            }
        }
        return "";
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : phonebook.keySet()) {
            sb.append(key).append(" ").append(phonebook.get(key)).append("\n");
        }
        return sb.toString();
    }
}
