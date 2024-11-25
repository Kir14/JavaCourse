package modules.five.arrays.revers;

public class MyArray {
    private String[] arrStr;

    public MyArray(String[] arrStr) {
        this.arrStr = arrStr;
    }

    public MyArray(String line) {
        arrStr = line.split(",?\\s+");
    }

    public String[] getArrStr() {
        return arrStr;
    }

    public void setArrStr(String[] arrStr) {
        this.arrStr = arrStr;
    }

    public void reverseArray() {
        for (int i = 0; i < arrStr.length / 2; i++) {
            String temp = arrStr[arrStr.length - 1 - i];
            arrStr[arrStr.length - 1 - i] = arrStr[i];
            arrStr[i] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String el : arrStr) {
            sb.append(el);
            sb.append("\n");
        }
        return sb.toString();
    }

}
