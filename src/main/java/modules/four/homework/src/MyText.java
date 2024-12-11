package modules.four.homework.src;

public class MyText {

    /*
    Вырезать подстроку из строки начиная с первого вхождения символа(А) до,
    последнего вхождения символа(B).
     */
    public static String replaceAB(String line, char a, char b) {
        int indexA = line.indexOf(a);
        int indexB = line.lastIndexOf(b);
        return line.substring(indexA, indexB + 1);
    }

    /*
    2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в
    позиции 0
     */

    public static String replaceByIndex(String line, int index) {
        return line.replaceAll(String.valueOf(line.charAt(index)), String.valueOf(line.charAt(0)));
    }

}
