package modules.five.homework.arrays;

import java.util.Arrays;

public class MainArrays {
    public static void main(String[] args) {

        System.out.println("\n-------------- Задание 1 ------------------");
        /*
         1)Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы
        массива на экран сначала в строку, отделяя один элемент от другого пробелом, а
         затем в столбик (отделяя один элемент от другого началом новой строки). Перед
         созданием массива подумайте, какого он будет размера.
         */
        int[] arr1 = new int[10];
        for (int i = 1; i <= 10; i++) {
            arr1[i - 1] = i * 2;
        }
        outputArray(arr1, " ");
        outputArray(arr1, "\n");

        System.out.println("\n-------------- Задание 2 ------------------");
        /*
         2)Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в
        строку, а затем этот же массив выведите на экран тоже в строку, но в обратном
        порядке (99 97 95 93 … 7 5 3 1).
        */
        int[] arr2 = new int[50];
        for (int i = 1; i < 100; i += 2) {
            arr2[i / 2] = i;
        }
        outputArray(arr2, " ");
        System.out.println();
        Arrays.stream(arr2)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.println("\n-------------- Задание 3 ------------------");
        /*
         3)Создайте массив из 15 случайных целых чисел из отрезка [0; 99]. Выведите
        массив на экран. Подсчитайте сколько в массиве чётных элементов и выведете
        это количество на экран на отдельной строке.
        */
        int[] arr3 = new int[15];
        for (int i = 0; i < 15; i++) {
            arr3[i] = (int) (Math.random() * 100.0);
        }
        outputArray(arr3, " ");
        System.out.println();
        System.out.println("Количество четных элементов = "
                + Arrays.stream(arr3)
                .filter(w -> w % 2 == 0)
                .count()
        );

        System.out.println("\n-------------- Задание 4 ------------------");
        /*
         4)Создайте массив из 20 случайных целых чисел из отрезка [0;20]. Выведите
        массив на экран в строку. Замените каждый элемент с нечётным индексом на
        ноль. Снова выведете массив на экран на отдельной строке.
        */
        int[] arr4 = new int[20];
        for (int i = 0; i < 20; i++) {
            arr4[i] = (int) Math.round(Math.random() * 20.0);
        }
        Arrays.stream(arr4).forEach(s -> System.out.print(s + " "));
        System.out.println();
        for (int i = 1; i < 20; i += 2) {
            arr4[i] = 0;
        }
        outputArray(arr4, " ");
        System.out.println();

        System.out.println("\n-------------- Задание 5 ------------------");
        /*
         5)Создайте 2 массива из 5 случайных целых чисел из отрезка [0;15] каждый,
        выведите массивы на экран в двух отдельных строках. Посчитайте среднее
        арифметическое элементов каждого массива и сообщите, для какого из
        массивов это значение оказалось больше (либо сообщите, что их средние
        арифметические равны)
         */
        int[] arr51 = new int[5];
        int[] arr52 = new int[5];

        for (int i = 0; i < 5; i++) {
            arr51[i] = (int) Math.round(Math.random() * 15.0);
            arr52[i] = (int) Math.round(Math.random() * 15.0);
        }
        outputArray(arr51, " ");
        System.out.println();
        outputArray(arr52, " ");
        System.out.println();
        double avg51 = Arrays.stream(arr51)
                .average()
                .getAsDouble();
        double avg52 = Arrays.stream(arr52)
                .average()
                .getAsDouble();

        if (avg52 == avg51) {
            System.out.println("Среднее арифметические равны");
        } else {
            System.out.println("Больше " + (avg51 > avg52 ? "avg51 = " + avg51 : "avg52 = " + avg52));
        }
    }

    public static void outputArray(int[] arr, String delimiter) {
        for (int el : arr) {
            System.out.print(el + delimiter);
        }
    }
}
