package modules.five.homework.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;

public class ExtraTasksArrays {
    public static void main(String[] args) {

        System.out.println("\n-------------- Задание 1 ------------------");
        /*
         1) Найти произведение элементов, кратных 3.
         */
        int[] arr1 = new int[10];
        createArray(arr1, arr1.length, 1, 10);
        outputArray(arr1, " ");
        System.out.println();
        int comp1 = 1;
        boolean exist3 = false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 3 == 0) {
                comp1 *= arr1[i];
                exist3 = true;
            }
        }
        if (exist3)
            System.out.println("произведение элементов, кратных 3 = " + comp1);
        else
            System.out.println("Нет элементов, кратных 3");


        System.out.println("\n-------------- Задание 2 ------------------");
        /*
         2) Найти среднее арифметическое элементов с нечетными номерами.
         */
        int[] arr2 = new int[10];
        createArray(arr2, arr2.length, 0, 10);
        outputArray(arr2, " ");
        System.out.println();
        int sum2 = 0;
        for (int i = 1; i < arr2.length; i += 2) {
            sum2 += arr2[i];
        }
        System.out.println("среднее арифметическое элементов с нечетными номерами = " + (double) sum2 / (arr2.length / 2));


        System.out.println("\n-------------- Задание 3 ------------------");
        /*
         3) Найти средне арифметическое элементов массива, превосходящих некоторое
        число С.
         */
        int[] arr3 = new int[10];
        createArray(arr3, arr3.length, 0, 10);
        outputArray(arr3, " ");
        System.out.println();
        int c = 4;
        System.out.println("средне арифметическое элементов массива, превосходящих " + c + " = "
                + Arrays.stream(arr3)
                .filter(w -> w > c)
                .average()
                .getAsDouble()
        );


        System.out.println("\n-------------- Задание 4 ------------------");
        /*
         4) Найти наименьший нечетный элемент.
         */
        int[] arr4 = new int[10];
        createArray(arr4, arr4.length, 0, 10);
        outputArray(arr4, " ");
        System.out.println();
        System.out.println("наименьший нечетный элемент = "
                + Arrays.stream(arr4)
                .filter(w -> w % 2 == 1)
                .min()
                .getAsInt()
        );


        System.out.println("\n-------------- Задание 5 ------------------");
        /*
         5) «Сожмите» массив, выбросив из него каждый второй элемент.
        «Освободившиеся» места массива заполните нулями.
         */
        int[] arr5 = new int[9];
        createArray(arr5, arr5.length, 0, 10);
        outputArray(arr5, " ");
        System.out.println();
        for (int i = 1; i < (int) Math.round(arr5.length / 2.0); i++) {
            arr5[i] = arr5[i * 2];
        }
        for (int i = (int) Math.round(arr5.length / 2.0); i < arr5.length; i++) {
            arr5[i] = 0;
        }
        outputArray(arr5, " ");
        System.out.println();


        System.out.println("\n-------------- Задание 6 ------------------");
        /*
         6) Проверить, различны ли все элементы массива.
         */
        int[] arr6 = new int[4];
        createArray(arr6, arr6.length, 0, 10);
        outputArray(arr6, " ");
        System.out.println();
        //Первый способ
        arr6 = Arrays.stream(arr6)
                .sorted()
                .toArray();
        boolean diff = true;
        for (int i = 0; i < arr6.length - 1; i++) {
            if (arr6[i] == arr6[i + 1]) {
                diff = false;
                break;
            }
        }
        System.out.println(diff ? "Все элементы различны" : "Есть одинаковые элементы");
        //Второй способ
        int[] arr62 = Arrays.stream(arr6)
                .distinct()
                .toArray();
        System.out.println(arr62.length == arr6.length ? "Все элементы различны" : "Есть одинаковые элементы");


        System.out.println("\n-------------- Задание 7 ------------------");
        /*
         7) Подсчитать, сколько раз встречается элемент с заданным значением.
         */
        int[] arr7 = new int[10];
        createArray(arr7, arr7.length, 0, 10);
        outputArray(arr7, " ");
        System.out.println();
        HashMap<Integer, Integer> map7 = new HashMap<>();
        for (int el : arr7) {
            if (!map7.containsKey(el)) {
                map7.put(el, 1);
            } else {
                map7.put(el, map7.get(el) + 1);
            }
        }
        for (Entry entry : map7.entrySet()) {
            System.out.println(entry.getKey() + " кол-во = " + entry.getValue());
        }


        System.out.println("\n-------------- Задание 8 ------------------");
        /*
         8) Найти второй по величине (т.е. следующий по величине за максимальным)
        элемент в массиве.
         */
        int[] arr8 = new int[7];
        createArray(arr8, arr8.length, 0, 10);
        outputArray(arr8, " ");
        System.out.println();

        int max8 = Arrays.stream(arr8)
                .max()
                .getAsInt();

        int prevMax8;
        try {
            prevMax8 = Arrays.stream(arr8)
                    .filter(w -> w != max8)
                    .max()
                    .getAsInt();
            System.out.println("второй по величине " + prevMax8);
        } catch (Exception e) {
            System.out.println("второго по величине нет");
        }

        OptionalInt optPrevMax8 = Arrays.stream(arr8)
                .filter(w -> w != max8)
                .max();
        if (optPrevMax8.isPresent()) {
            System.out.println("второй по величине " + optPrevMax8.getAsInt());
        } else {
            System.out.println("второго по величине нет");
        }


        System.out.println("\n-------------- Задание 9 ------------------");
        /*
         9) Найти наименьший элемент среди элементов с четными индексами массива
         */
        int[] arr9 = new int[7];
        createArray(arr9, arr9.length, 0, 10);
        outputArray(arr9, " ");
        System.out.println();

        int minIndex9 = 0;
        for (int i = 0; i < arr9.length; i += 2) {
            if (arr9[i] < arr9[minIndex9]) {
                minIndex9 = i;
            }
        }
        System.out.println("наименьший элемент среди элементов с четными индексами = " + arr9[minIndex9]);


        System.out.println("\n-------------- Задание 10 ------------------");
        /*
         10) Найти максимальный элемент в массиве и поменять его местами с нулевым
        элементом
         */
        int[] arr10 = new int[7];
        createArray(arr10, arr10.length, 0, 10);
        outputArray(arr10, " ");
        System.out.println();

        int maxIndex10 = 0;
        for (int i = 0; i < arr10.length; i++) {
            if (arr10[i] > arr10[maxIndex10]) {
                maxIndex10 = i;
            }
        }
        int temp = arr10[maxIndex10];
        arr10[maxIndex10] = arr10[0];
        arr10[0] = temp;
        outputArray(arr10, " ");
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
