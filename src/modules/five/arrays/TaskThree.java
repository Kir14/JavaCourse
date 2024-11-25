package modules.five.arrays;

public class TaskThree {
    public static void main(String[] args) {
        int length = 7;
        String[][] arr = new String[length][length];
        for (int i = 0; i < length / 2 + 1; i++) {
            for (int j = 0; j < length / 2 + 1; j++) {
                if ((j == i) || (j == length - 1 - i)) {
                    arr[i][j] = "X";
                    arr[i][length - 1 - j]= "X";
                    arr[length - 1 - i][j] = "X";
                    arr[length - 1 - i][length - 1 - j] = "X";
                } else {
                    arr[i][j] = " ";
                    arr[i][length - 1 - j]= " ";
                    arr[length - 1 - i][j] = " ";
                    arr[length - 1 - i][length - 1 - j] = " ";
                }
            }
        }
        for(String[] line : arr){
            for(String el : line){
                System.out.print(el);
            }
            System.out.println();
        }
    }
}
