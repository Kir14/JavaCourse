package modules.four.integer.src;

/*
1. Запустите код проекта IntegerExperiments. Найдите ошибку, исправьте её заменой Integer на int.
2. Реализуйте статический метод sumDigits, чтобы он считал сумму цифр в числе и возвращал сумму в результате своей работы. Для реализации метода можете использовать методы:
•	класса Integer: toString(), parseInt();
•	класса String: charAt(), length(), valueOf().
3. Выведите в консоль суммы цифр чисел: 12345, 10, 5059191.

 */

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(12345));
        System.out.println(sumDigitsWayTwo(12345));
        System.out.println(sumDigits(10));
        System.out.println(sumDigitsWayTwo(10));
        System.out.println(sumDigits(5059191));
        System.out.println(sumDigitsWayTwo(5059191));


    }

    public static Integer sumDigits(Integer number) {
        String strNumber = number.toString();
        int sum = 0;
        for (int i = 0; i < strNumber.length(); i++) {
            sum += Integer.parseInt(String.valueOf(strNumber.charAt(i)));
        }
        return sum;
    }

    public static Integer sumDigitsWayTwo(Integer number) {
        String strNumber = number.toString();
        int sum = 0;
        for (int i = 0; i < strNumber.length(); i++) {
            sum += Character.getNumericValue(strNumber.charAt(i));
        }

        return sum;
    }
}
