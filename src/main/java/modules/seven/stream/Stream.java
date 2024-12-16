package modules.seven.stream;

import modules.seven.stream.person.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Stream {
    public static void main(String[] args) {

        /*
        ### Задание 1: Фильтрация и преобразование
         */
        System.out.println("###  Задание 1: Фильтрация и преобразование");
        //1. Создайте список строк
        List<String> names = Arrays.asList("Anna", "Mark", "Paul", "Peter", "Maria", "John", "Anastasia");
        System.out.println(names.stream().collect(Collectors.joining(", ")));

        /*
        2. Используйте Stream API, чтобы:
           - Оставить только те имена, которые начинаются с буквы "A".
           - Преобразовать их в верхний регистр.
           - Собрать результат в новый список.
         */
        List<String> namesA = names.stream()
                .filter(s -> s.charAt(0) == 'A')
                .map(String::toUpperCase)
                .toList();
        System.out.println("Имена с 'A' в верхнем регистре");
        namesA.forEach(System.out::println);

        /*
        ### Задание 2: Преобразование и подсчёт
         */
        System.out.println("\n### Задание 2: Преобразование и подсчёт");
        //1. Создайте список чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        /*
        2. Используйте Stream API, чтобы:
       - Преобразовать каждый элемент списка в его квадрат.
       - Подсчитать количество чисел, которые больше 20.
         */

        System.out.println("количество чисел в квадрате, которые больше 20: " + numbers.stream()
                .map(x -> Math.pow(x, 2))
                .filter(x -> x > 20)
                .count());


        /*
        ### Задание 3: Группировка по критерию
         */
        System.out.println("\n### Задание 3: Группировка по критерию");

        /*
        1. Создайте список объектов Person, каждый из которых имеет поля name и age.
        */

        /*
        2. Заполните список несколькими людьми разных возрастов.
        */
        List<Person> people = Arrays.asList(
                new Person("Oleg", 12),
                new Person("Kir", 18),
                new Person("Misha", 25),
                new Person("Rick", 15),
                new Person("Bolt", 18),
                new Person("Tim", 34),
                new Person("Tom", 47)

        );

        /*
        3. Используйте Stream API, чтобы сгруппировать людей по возрасту (например, до 18 лет и 18+),
        и соберите результат в Map<String, List<Person>>.
         */

        Map<String, List<Person>> groups = people.stream()
                .collect(groupingBy(p -> {
                    if (p.getAge() < 18) {
                        return "до 18 лет";
                    } else if (p.getAge() == 18) {
                        return "18 лет";
                    } else {
                        return "18+";
                    }
                }));
        groups.forEach((k, v) -> {
            v.forEach(p -> System.out.println(k + "   " + p));
        });


        /*
        ### Задание 4: Поиск и отображение данных
        */
        System.out.println("\n### Задание 4: Поиск и отображение данных");
        /*
        1. Создайте список чисел от -10 до 10. IntStream
        */
        List<Integer> listStream = IntStream.rangeClosed(-10, 10).boxed().toList();
        listStream.forEach(x -> System.out.print(x + "  "));
        /*
        2. Используйте Stream API, чтобы найти:
           - Наименьшее положительное число.
           - Наибольшее отрицательное число.
           - Преобразуйте их в строку и выведите в формате: "Min Positive: X, Max Negative: Y".
         */
        Optional<Integer> minEl = listStream.stream()
                .filter(x -> x > 0)
                .min(Integer::compare);
        System.out.println("\nНаименьшее положительное число " + (minEl.map(Object::toString).orElse("нет")));

        Optional<Integer> maxEl = listStream.stream()
                .filter(x -> x < 0)
                .max(Integer::compare);
        System.out.println("Наибольшее отрицательное число " + (maxEl.map(Object::toString).orElse("нет")));


        /*
        ### Задание 5: Подсчёт уникальных значений и сортировка
        */
        System.out.println("\n### Задание 5: Подсчёт уникальных значений и сортировка");
        /*
        1. Создайте список строк, в котором некоторые слова повторяются.
        */
        List<String> wordsRepeated = List.of(
                "Hello",
                "World",
                "Java",
                "Hello",
                "Hello",
                "Java"
        );
        System.out.println("Весь список:");
        wordsRepeated.forEach(s -> System.out.print(s + "  "));
        System.out.println();
        /*
        2. Используйте Stream API, чтобы:
           - Найти уникальные слова и отсортировать их в алфавитном порядке.
           - Подсчитать частоту каждого уникального слова и вывести в формате Map<String, Long>.
         */
        Map<String, Long> collectWordsCount;

        List<String> sortedWords = wordsRepeated.stream()
                .distinct()
                .sorted()
                .toList();
        System.out.print("Уникальные значения и отсортированные в алфавитном порядке: ");
        sortedWords.forEach(s -> System.out.print(s + "  "));
        System.out.println();

        System.out.println("Уникальные с подсчетом:");
        collectWordsCount = wordsRepeated.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collectWordsCount.forEach((k, v) -> System.out.println(k + "    " + v));


        /*
        ### Задание 6: Использование Optional для обработки пустых значений
        */
        System.out.println("\n### Задание 6: Использование Optional для обработки пустых значений");
        /*
        1. Создайте список строк, например, List<String> words = Arrays.asList("apple", "banana", "cherry", "", null, "date");.
        */
        List<String> wordsOptional = Arrays.asList("apple", "banana", "cherry", "", null, "date");
        //List<String> wordsOptional = Arrays.asList("", "", null, null);
        System.out.println("Список слов: ");
        wordsOptional.forEach(s -> System.out.print(s + " "));
        System.out.println();
        /*
        2. Используйте Stream API и Optional, чтобы:
           - Отфильтровать пустые строки и null.
           - Найти строку с максимальной длиной (при помощи max()), завернув её в Optional.
           - Если максимальная строка найдена, выведите её, иначе выведите сообщение "No valid strings found."
         */
        System.out.println("Строка с максимальной длиной: " + wordsOptional.stream()
                .filter(s -> s != null && !s.isEmpty())
                .max(Comparator.comparingInt(String::length))
                .map(Object::toString)
                .orElse("No valid strings found.")
        );
        //.forEach(s -> System.out.print(s + " "));

        /*
        - Сгруппировать строки по их длине в Map<Integer, List<String>>.
           - Вывести результат в виде Map с ключами-длинами строк и значениями-списками слов, соответствующей длины.
         */
        Map<Integer, List<String>> mapLengthWords = wordsOptional.stream()
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.groupingBy(String::length));
        mapLengthWords.forEach((k, v) -> {
            System.out.print(k + " : ");
            v.forEach(p -> System.out.print(p + "  "));
            System.out.println();
        });

        /*
        ### Задание 7: Подсчёт с использованием Collectors.counting и Collectors.groupingBy
        */
        System.out.println("\n### Задание 7: Подсчёт с использованием Collectors.counting и Collectors.groupingBy");
        /*
        1. Создайте список чисел, например, List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);.
        */
        List<Integer> numbers7 = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        //List<Integer> numbers7 = Arrays.asList(1, 1, 3, 3, 15, 13, 13, 5);
        System.out.println("Список чисел:");
        numbers7.forEach(n -> System.out.print(n + "   "));
        System.out.println();
        /*
        2. Используйте Stream API и Optional, чтобы:
           - Найти первое четное число в списке (используя findFirst()).
           - Если число найдено, увеличьте его на 10 и выведите, иначе выведите "No even number found."
        */
        System.out.println("Первое четное число, увеличенное на 10: "
                + numbers7.stream()
                .filter(n -> n % 2 == 0)
                .findFirst()
                .map(n -> String.valueOf(n * 10))
                .orElse("No even number found.")
        );

        /*
        3. Используйте Stream API и Collectors для группировки:
           - Подсчитайте, сколько раз каждое число встречается в списке, используя Collectors.groupingBy и Collectors.counting.
           - Сохраните результат в Map<Integer, Long> и выведите его.
         */
        (numbers7.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        ).forEach((k, v) -> System.out.println(k + " count " + v));

        /*
        ### Задание 8: Соединение строк с использованием Collectors.joining
        */
        System.out.println("\n### Задание 8: Соединение строк с использованием Collectors.joining");
        /*
        1. Создайте список имен List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");.
        */
        List<String> names8 = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        /*
        2. Используйте Collectors.joining, чтобы:
           - Объединить все имена в одну строку, разделяя их запятыми и добавляя квадратные скобки в начале и конце.
           - Например, результат должен быть "[Alice, Bob, Charlie, Dave]".
         */
        System.out.println(names.stream()
                .collect(Collectors.joining(", ","[", "]"))
        );


    }
}
