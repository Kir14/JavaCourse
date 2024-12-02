package modules.five.search;

/*
1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
•	прямым перебором по ArrayList,
•	бинарным поиском по сортированному ArrayList,
•	поиском в HashSet,
•	поиском в TreeSet.
2. Измерьте и сравните длительность каждого метода поиска.
Формат вывода результатов поиска:
Поиск перебором: номер найден/не найден, поиск занял 34нс
Бинарный поиск: номер найден/не найден, поиск занял 34нс
Поиск в HashSet: номер найден/не найден, поиск занял 34нс
Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.
В видео Поиск и сортировка неточно указана оценка результата работы метода бинарного поиска Collections.binarySearch(). Метод возвращает int, если возвращаемое значение больше или равно нулю — это означает, что элемент найден. Если возвращаемое значение int меньше нуля — элемент в коллекции не найден.

Рекомендации
•	Сортировка не входит в учёт времени для бинарного поиска.
•	Для детального сравнения методов поиска используйте время в наносекундах:
     System.nanoTime()
•	Используйте правила генерации номеров для получения более 2 млн номеров:
XYZ — различные буквы, N — цифры, R — регион (от 01 до 199);
XNNNYZR — пример, A111BC197, Y777HC66,
таким образом, количество номер будет достаточно для оценки времени поиска даже в миллисекундах.

 */

import java.util.*;

public class TestSearch {
    public static void main(String[] args) {
        int count = 10;
        ArrayList<String> numbersList = new ArrayList<>(count);
        createNumber(numbersList, count);
        HashSet<String> numbersSet = new HashSet<>(numbersList);
        TreeSet<String> numbersTree = new TreeSet<>(numbersList);
        //outputList(numbers);
        Scanner scanner = new Scanner(System.in);


        for (long start, duration; ; ) {
            String line = scanner.nextLine();
            int index = -1;

            //Перебор
            start = System.nanoTime();
            for (int i = 0; i < count; i++) {
                if (numbersList.get(i).equals(line)) {
                    index = i;
                    break;
                }
            }
            duration = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + line + " "
                    + (index == -1 ? "не найден" : "найден") + ", поиск занял " + duration);

            //Бинарный поиск
            start = System.nanoTime();
            index = Collections.binarySearch(numbersList, line);
            duration = System.nanoTime() - start;
            System.out.println("Бинарный поиск: " + line + " "
                    + (index < 0 ? "не найден" : "найден") + ", поиск занял " + duration);

            boolean isFind;
            //Поиск в HashSet
            start = System.nanoTime();
            isFind = numbersSet.contains(line);
            duration = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + line + " "
                    + (!isFind ? "не найден" : "найден") + ", поиск занял " + duration);

            //Поиск в TreeSet
            start = System.nanoTime();
            isFind = numbersTree.contains(line);
            duration = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: " + line + " "
                    + (!isFind ? "не найден" : "найден") + ", поиск занял " + duration);
        }
    }

    public static void createNumber(ArrayList<String> numbers, int count) {
        StringBuilder sb = new StringBuilder();
        for (char x = 'A'; x <= 'Z' && count > 0; x++) {
            sb.append((x));
            for (int n = 1; n <= 999 && count > 0; n++) {
                sb.append(String.format("%03d", n));
                for (char y = 'A'; y <= 'Z' && count > 0; y++) {
                    sb.append(y);
                    for (char z = 'A'; z <= 'Z' && count > 0; z++) {
                        sb.append(z);
                        for (int r = 1; r <= 197 && count > 0; r++, count--) {
                            sb.append(String.format("%03d", r));
                            numbers.add(sb.toString());
                            sb.replace(sb.length() - 3, sb.length(), "");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.replace(sb.length() - 3, sb.length(), "");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void outputList(List<String> list) {
        for (String el : list) {
            System.out.println(el);
        }
    }
}
