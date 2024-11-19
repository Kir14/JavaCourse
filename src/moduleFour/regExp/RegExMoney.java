package moduleFour.regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Внесите изменения в проект StringExperiments, чтобы суммы заработка каждого человека
извлекались из текста регулярным выражением, а в конце программы рассчитывалась
и распечатывалась общая сумма заработка людей.
 */

public class RegExMoney {
    public static void main(String[] args) {
        String text = "Вася заработал 5000,65 рублей, Петя - 7563.42 рубля, а Маша - 30000 рублей";
        Pattern pattern = Pattern.compile("\\d+[,.]*\\d*");
        Matcher matcher = pattern.matcher(text);
        double sum = 0;
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
            sum += Double.parseDouble(text.substring(matcher.start(), matcher.end()).replace(',','.'));
        }
        System.out.println(sum);
    }
}

