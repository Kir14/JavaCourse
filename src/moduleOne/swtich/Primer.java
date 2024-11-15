package moduleOne.swtich;

import java.util.Scanner;

public class Primer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        switch(scanner.nextInt()){
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;


        }
    }
}
