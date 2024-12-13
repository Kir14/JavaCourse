package modules.seven.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        /*
        3. Используйте Stream API, чтобы сгруппировать людей по возрасту (например, до 18 лет и 18+), и соберите результат в Map<String, List<Person>>.
         */
    }
}
