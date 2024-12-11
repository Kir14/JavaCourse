package modules.four.regexp.scr.phone;

/*
Реализуйте  удаление лишних символов при вводе номера телефона в консоли
и проверку соответствия номера формату мобильных номеров России.
Если введённую строку нельзя привести к формату мобильного номера — выводите сообщение о неверном вводе.
Телефон может быть введен не только в формате 79091234567, но и с лишними символами.

Пример ввода номеров и результата вывода программы

Ввод пользователя в консоль	    Вывод программы в консоль	    Примечание
+7 909 123-45-67	            79091234567	                    Символов 11 в номере, код страны 7 — номер верный.
+7 (909) 1234567	            79091234567	                    Символов 11 в номере, код страны 7 — номер верный.
8-905-1234567	                79051234567	                    Символов 11 в номере, первый символ 8 (код выхода на мобильный номер) заменяем на код страны 7 — номер верный.
9-453-1234567	                Неверный формат номера	        Символов 11 в номере, первый символ после очистки 9, это не 7 и не 8 — формат номера неверный.
8-905-123	                    Неверный формат номера	        Символов 7 в номере — номер неверный.
905-1234567	                    79051234567	                    Количество символов 10 после очистки — значит, приводим к формату номера с 7.
8-905-12345672342	            Неверный формат номера	        Символов в номере больше чем 11 — номер неверный.

 */


public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setPhone("+7 909 123-45-67");
        phone.setPhone("+7 (909) 1234567");
        phone.setPhone("8-905-1234567");
        phone.setPhone("9-453-1234567");
        phone.setPhone("8-905-123");
        phone.setPhone("905-1234567");
        phone.setPhone("8-905-12345672342");

    }
}
