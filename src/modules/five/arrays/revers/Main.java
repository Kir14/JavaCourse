package modules.five.arrays.revers;

/*
1. Создайте массив из мнемонической фразы:
Каждый охотник желает знать, где сидит фазан.
2. Напишите код, который меняет порядок расположения элементов внутри массива на обратный.

 */

public class Main {
    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        MyArray arr = new MyArray(line);
        System.out.print(arr);
        arr.reverseArray();
        System.out.println("==================================");
        System.out.print(arr);
    }
}
