package modules.nine.homework.json;


/*
1. Получает HTML-код страницы «Список станций Московского метрополитена» https://www.moscowmap.ru/metro.html#lines с помощью библиотеки jsoup.
2. Парсит полученную страницу и получает из неё:
•	Линии московского метро (получаете имя линии, номер линии, цвет парсить не надо).
•	Станции московского метро (получаете имя станции, номер линии).
3. Создаёт и записывает на диск JSON-файл со списком станций по линиям и списком линий по формату JSON-файла из проекта SPBMetro (файл map.json).
4. Читает файл и выводит в консоль количество станций на каждой линии.
Рекомендации
•	По умолчанию Jsoup читает 2 Мб данных с запрашиваемой страницы. Чтобы снять это ограничение, необходимо добавить вызов метода maxBodySize(0), устанавливающий максимальное значение получаемых данных:
Document doc = Jsoup.connect(URL).maxBodySize(0).get();
значение 0 означает, что нет ограничений на принимаемый объём данных.
•	При изучении кода страницы удобно использовать консоль разработчика в браузере. Для этого нажмите F12, перейдите во вкладку Elements и найдите тег <div id="metrodata">.
В нём содержатся таблицы с линиями, станциями и пересадками. Обращайте внимание на классы, напишите селекторы на основе найденных классов. Посмотрите,
как получать элементы по селекторам в документации JSoup.
•	Для более быстрого поиска нужных селекторов используйте онлайн сервис jsoup https://try.jsoup.org/

 */


/*
Потренироваться в работе с библиотекой jsoup и формированием JSON-файлов.
Что нужно сделать
1.	Пропарсите и записывайте в JSON-файл переходы между станциями в дополнение к линиям и станциям (коллекции имя станции, номер линии, между которым есть переходы).
2.	Выведите в консоль количество переходов в метро.

 */

import modules.nine.homework.json.classes.Line;
import modules.nine.homework.json.parsers.JsonParser;
import modules.nine.homework.json.parsers.JsoupParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class MainJson {
    public static void main(String[] args) {
        JsoupParser jsoup = new JsoupParser("src/main/java/modules/nine/homework/json/data/site.html");
        jsoup.saveData();
        System.out.println("Количество всего станций: " + jsoup.lines.values().stream()
                .mapToLong(line -> line.stations.size())
                .sum()
        );
        jsoup.lines.values().stream()
                .sorted(Comparator.comparing(Line::getNumberLine))
                .forEach(line -> System.out.println(line.getNameLine() + ", количество станций: "
                        + line.stations.size())
                );
        System.out.println("Количество переходов: " + jsoup.connections.size());

        JsonParser.writeSubway(new ArrayList<>(jsoup.lines.values()), jsoup.connections);

        try {
            JsonParser json = new JsonParser("src/main/java/modules/nine/homework/json/data/map.json");
            System.out.println("Количество всего станций: " + json.lines.stream()
                    .mapToLong(line -> line.stations.size())
                    .sum()
            );
            json.lines.forEach(line ->
                    System.out.println(line.getNameLine() + ", количество станций: "
                            + line.stations.size())
            );
            System.out.println("Количество переходов: " + json.connections.size());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
