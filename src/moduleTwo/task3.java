package moduleTwo;

/*
Вычислить:  1+2+4+8+…+256
 */
public class task3 {
    public static void main(String[] args) {
        int start = 1;
        int sum = 0;
        while (start < 257) {
            sum += start;
            start *= 2;
        }
        System.out.println(sum);
    }
}
