package moduleFour.IntegerExperiments.src;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(12345));
        System.out.println(sumDigitsWayTwo(12345));
        System.out.println(sumDigits(10));
        System.out.println(sumDigitsWayTwo(10));
        System.out.println(sumDigits(5059191));
        System.out.println(sumDigitsWayTwo(5059191));


    }

    public static Integer sumDigits(Integer number) {
        String strNumber = number.toString();
        int sum = 0;
        for (int i = 0; i < strNumber.length(); i++) {
            sum += Integer.parseInt(String.valueOf(strNumber.charAt(i)));
        }
        return sum;
    }

    public static Integer sumDigitsWayTwo(Integer number) {
        String strNumber = number.toString();
        int sum = 0;
        for (int i = 0; i < strNumber.length(); i++) {
            sum += Character.getNumericValue(strNumber.charAt(i));
        }
        return sum;
    }
}
