package moduleFour.stringExperiments.src;

/*
Распечатайте коды всех букв английского алфавита и сами буквы.
 */

public class Alphabet {
    public static void main(String[] args) {
        for (int i = 'A'; i <= 'z'; i++) {
            System.out.printf("%4s %4s %n", i, (char) i);
        }
        String alphabetRus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for (int i = 0; i < alphabetRus.length(); i++) {
            System.out.println(alphabetRus.charAt(i) + " " + (int) alphabetRus.charAt(i));
        }
    }
}
