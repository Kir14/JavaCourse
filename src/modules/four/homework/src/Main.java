package modules.four.homework.src;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String line = "adad 1232 dds qfkdfk q q qfk  l dsa l dsa dsadl 321  fdd si i";

        /*
        1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до,
        последнего вхождения символа(B).
        2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в
        позиции 0
         */
        System.out.println(MyText.replaceAB(line, 'q', 'l'));
        System.out.println(MyText.replaceByIndex(line, 3));

        /*
        3)В исходном файле находятся слова, каждое слово на новой строке. После
        запуска программы должен создать файл, который будет содержать в себе
        только палиндромы
         */
        TextFormatter file = new TextFormatter("D:\\scripts\\tests\\testJava.txt");
        file.getPalindromes("D:\\scripts\\tests\\testJavaResult.txt");

        /*
        Текстовый файл содержит текст. После запуска программы в другой файл
        должны записаться только те предложения в которых от 3-х до 5-ти слов. Если в
         предложении присутствует слово-палиндром, то не имеет значения какое кол-во
         слов в предложении, оно попадает в новый файл.
         Пишем все в ООП стиле. Создаём класс TextFormater
          в котором два статических метода:
         1. Метод принимает строку и возвращает кол-во слов в строке.
         2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если
         есть возвращает true, если нет false
         В main считываем файл.
        Разбиваем текст на предложения. Используя методы класса TextFormater
        определяем подходит ли нам предложение. Если подходит добавляем его в
        новый файл
         */
        TextFormatter fileText = new TextFormatter("D:\\scripts\\tests\\testJavaText.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\scripts\\tests\\testJavaTextResult.txt"))) {
            for (String[] sentences : fileText.getSentences()) {
                for (String sentence : sentences) {
                    int countWords = TextFormatter.countWords(sentence);
                    if (((countWords > 2) && (countWords < 6)) || TextFormatter.hasPalindrome(sentence)) {
                        System.out.println(sentence);
                        bw.write(sentence + "\n");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
