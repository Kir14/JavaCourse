package moduleTwo;


/*
Вычислить:  1+2+4+8+…+256
 */
public class task3 {
    public static void main(String[] args) {

        System.out.println("way one:");
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += (int) Math.pow(2, i);
        }
        System.out.println(sum);

        System.out.println("way two:");
        sum = 0;
        for (int start = 1; start < 257; start *= 2) {
            sum += start;
        }

        System.out.println(sum);

        System.out.println("way three:");
        sum = 0;
        int start = 1;
        while (start < 257) {
            sum += start;
            start *= 2;
        }
        System.out.println(sum);
    }
}
