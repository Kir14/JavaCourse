package modules.five.homework.arrays;

import java.util.Arrays;
import java.util.Scanner;

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
        createArray(arr3, arr3.length, 0, 99);
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
        createArray(arr4, arr4.length, 0, 20);
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
            System.out.println("Больше " + (avg51 > avg52 ? "avg первой = " + avg51 : "avg второй = " + avg52));
        }


        System.out.println("\n-------------- Задание 6 ------------------");
        /*
        6)Создайте массив из 4 случайных целых чисел из отрезка [0;10], выведите его
        на экран в строку. Определить и вывести на экран сообщение о том, является ли
        массив строго возрастающей последовательностью.
         */
        int[] arr6 = new int[4];
        createArray(arr6, arr6.length, 0, 10);
        Arrays.stream(arr6)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        boolean straightUp = true;
        for (int i = 0; i < 3; i++) {
            if (arr6[i] >= arr6[i + 1]) {
                straightUp = false;
                break;
            }
        }
        if (straightUp) {
            System.out.println("Строго возрастающая");
        } else {
            System.out.println("Не строго возрастающая");
        }


        System.out.println("\n-------------- Задание 7 ------------------");
        /*
         7)Создайте массив из 12 случайных целых чисел из отрезка [0;15]. Определите
        какой элемент является в этом массиве максимальным и сообщите индекс его
        последнего вхождения в массив.
        */
        int[] arr7 = new int[12];
        createArray(arr7, arr7.length, 0, 15);
        outputArray(arr7, " ");
        System.out.println();
        int maxIndex = 0;
        for (int i = 1; i < 12; i++) {
            if (!(arr7[i] < arr7[maxIndex])) {
                maxIndex = i;
            }
        }
        System.out.println("Максимальный элемент равен " + arr7[maxIndex] + ", индекс последнего вхождения = " + maxIndex);


        System.out.println("\n-------------- Задание 8 ------------------");
        /*
         8)Создайте два массива из 10 целых случайных чисел из отрезка [0;9] и третий
        массив из 10 действительных чисел. Каждый элемент с i-ым индексом третьего
        массива должен равняться отношению элемента из первого массива с i-ым
        индексом к элементу из второго массива с i-ым индексом. Вывести все три
        массива на экран (каждый на отдельной строке), затем вывести количество
        целых элементов в третьем массиве.
        */
        int[] arr81 = new int[10];
        int[] arr82 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr81[i] = (int) Math.round(Math.random() * 9);
            arr82[i] = (int) Math.round(Math.random() * 9);
        }
        double[] arr83 = new double[10];
        for (int i = 0; i < 10; i++) {
            arr83[i] = (double) arr81[i] / arr82[i];
        }
        outputArray(arr81, " ");
        System.out.println();
        outputArray(arr81, " ");
        System.out.println();
        Arrays.stream(arr83)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("Количество целый чисел в 3 массиве = " +
                Arrays.stream(arr83)
                        .filter(w -> w == (int) w)
                        .count()
        );


        System.out.println("\n-------------- Задание 9 ------------------");
        /*
         9)Пользователь должен указать с клавиатуры положительное число, а
        программа должна создать массив указанного размера из случайных целых
        чисел из [0;15] и вывести его на экран в строку. После этого программа должна
        определить и сообщить пользователю о том, сумма какой половины массива
        больше: левой или правой, либо сообщить, что эти суммы модулей равны. Если
        пользователь введёт неподходящее число, то выдать соответствующее
        сообщение
        */
        /*Scanner scanner9 = new Scanner(System.in);
        int count9 = scanner9.nextInt();
        while (count9 < 1) {
            System.out.println("Введите целое положительное число:");
            count9 = scanner9.nextInt();
        }*/
        int count9 = 4;
        int[] arr9 = new int[count9];
        createArray(arr9, arr9.length, 0, 15);
        outputArray(arr9, " ");
        System.out.println();
        int sum9Left = 0, sum9Right = 0;
        int addOdd = 0; //Для вычисления при нечетном количестве элементов
        if (count9 % 2 == 1) {
            addOdd = 1;
        }
        for (int i = 0; i < arr9.length / 2; i++) {
            sum9Left += arr9[i];
            sum9Right += arr9[i + arr9.length / 2 + addOdd];
        }
        if (sum9Left == sum9Right) {
            System.out.println("Суммы левой и правой частей равны");
        } else {
            System.out.println("Больше " +
                    (sum9Left > sum9Right ? "левая часть =" + sum9Left : "правая часть =" + sum9Right));
        }


        System.out.println("\n-------------- Задание 10 ------------------");
        /*
         10)Пользователь вводит с клавиатуры число большее 3, которое сохраняется в
        переменную n. Если пользователь ввёл не подходящее число, то программа
        должна выдать соответствующее сообщение. Создать массив из n случайных
        целых чисел из отрезка [0;n] и вывести его на экран. Создать второй массив
        только из чётных элементов первого массива, если они там есть, и вывести его
        на экран.
         */
        /*Scanner scanner10 = new Scanner(System.in);
        int n10 = scanner10.nextInt();
        while (n10 < 4) {
            System.out.println("Введите целое число больше 3:");
            n10 = scanner10.nextInt();
        }*/
        int n10 = 4;
        int[] arr10 = new int[n10];
        createArray(arr10, arr10.length, 0, n10);
        outputArray(arr10, " ");
        System.out.println();
        int[] arr102;
        arr102 = Arrays.stream(arr10)
                .filter(w -> w % 2 == 0)
                .toArray();
        arr102[0]=14;
        outputArray(arr102, " ");
        System.out.println();

    }

    public static void createArray(int[] arr, int count, int min, int max) {
        for (int i = 0; i < count; i++) {
            arr[i] = (int) (Math.random() * (max + 1 - min)) + min;
        }
    }

    public static void outputArray(int[] arr, String delimiter) {
        for (int el : arr) {
            System.out.print(el + delimiter);
        }
    }
}
