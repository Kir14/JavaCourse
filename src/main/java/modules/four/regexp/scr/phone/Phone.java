package modules.four.regexp.scr.phone;

/*
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

public class Phone {

    private String phone;

    public void setPhone(String line) {
        line = line.trim();
        line = line.replaceAll("\\D", "");
        //String
        if (checkNumberString(line)) {
            this.phone = line;
        }
        //Regex
        if (checkNumberRegex(line)) {
            this.phone = line;
        }
    }

    public boolean checkNumberString(String line) {
        switch (line.length()) {
            case 11:
                if (line.charAt(0) == '7') {
                    System.out.println(line);
                    return true;
                } else if (line.charAt(0) == '8') {
                    line = "7" + line.substring(1);
                    System.out.println(line);
                    return true;
                } else {
                    System.out.println("Неверный формат номера");
                    return false;
                }
            case 10:
                line = "7" + line;
                System.out.println(line);
                return true;
            default:
                System.out.println("Неверный формат номера");
                return false;
        }
    }

    public boolean checkNumberRegex(String line) {
        if (line.matches("7[0-9]{10}")) {
            System.out.println(line);
            return true;
        } else if (line.matches("8[0-9]{10}")) {
            line = "7" + line.substring(1);
            System.out.println(line);
            return true;
        } else if (line.matches("[0-9]{10}")) {
            line = "7" + line;
            System.out.println(line);
            return true;
        } else {
            System.out.println("Неверный формат номера");
            return false;
        }
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Phone = " + phone;
    }
}
