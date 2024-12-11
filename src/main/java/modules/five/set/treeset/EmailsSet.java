package modules.five.set.treeset;

import java.util.TreeSet;

/*
Что нужно сделать
1.	Напишите программу, в которой будет храниться перечень адресов электронной почты. Адреса можно добавлять через консоль командой ADD и печатать весь список командой LIST.
2.	Программа должна проверять корректность вводимых email’ов и печатать сообщение об ошибке при необходимости.
Принцип работы команд
•	LIST — выводит список электронных адресов.
•	ADD — проверяет и, если формат адреса верный, добавляет в множество.

 */

public class EmailsSet {
    private TreeSet<String> emails;

    public EmailsSet() {
        emails = new TreeSet<>();
    }

    public TreeSet<String> getEmails() {
        return emails;
    }

    public boolean addEmail(String email) {
        if (!email.matches("^[A-Za-z](\\.?\\w)*@[A-Za-z]+\\.[A-Za-z]+$")) {
            return false;
        }
        emails.add(email);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String el : emails) {
            sb.append(el).append("\n");
        }
        return sb.toString();
    }

}
