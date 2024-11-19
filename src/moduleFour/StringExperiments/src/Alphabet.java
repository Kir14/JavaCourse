package moduleFour.StringExperiments.src;

/*
Распечатайте коды всех букв английского алфавита и сами буквы.
 */

public class Alphabet {
    public static void main(String[] args) {
        for (int i = 'a'; i <= 'z'; i++) {
            System.out.printf("%4s %4s %n", i, (char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.printf("%4s %4s %n", i, (char) i);
        }
    }
}
