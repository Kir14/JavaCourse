package modules.four.regexp.scr;

/*
Пользователь вводит строку, в некоторой части которой содержится конфиденциальная информация. Ваша задача изменить строку и скрыть информацию в < >.
Напишите метод
String searchAndReplaceDiamonds(String text, String placeholder)
который будет заменять в переданной строке String text всё содержимое скобок <> (англ. diamonds) и сами скобки на переданную строку в String placeholder.

Пример работы
String safe = searchAndReplaceDiamonds(«Номер кредитной карты <4008 1234 5678> 8912», «***»);
В safe должна содержаться строка «Номер кредитной карты *** 8912».

 */

public class DiamondsRegex {
    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        return text.replaceAll("<.*>", placeholder);
    }
}
