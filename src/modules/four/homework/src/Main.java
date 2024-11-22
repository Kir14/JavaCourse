package modules.four.homework.src;


public class Main {
    public static void main(String[] args) {
        String line = "adad 1232 dds qfkdfk q q qfk  l dsa l dsa dsadl 321  fdd si i";
        System.out.println(MyText.replaceAB(line, 'q', 'l'));

        System.out.println(MyText.replaceByIndex(line, 3));

        TextFormatter file = new TextFormatter("D:\\scripts\\tests\\testJava.txt");
        file.getPalindromes("D:\\scripts\\tests\\testJavaResult.txt");

        /*
        Текстовый файл содержит текст. После запуска программы в другой файл
        должны записаться только те предложения в которых от 3-х до 5-ти слов. Если в
         предложении присутствует слово-палиндром, то не имеет значения какое кол-во
         слов в предложении, оно попадает в новый файл.
         Пишем все в ООП стиле. Создаём класс TextFormater
         */

        for (String[] sentences : file.getSentences()) {
            for (String sentence : sentences) {
                int countWords = TextFormatter.countWords(sentence);
                if ((countWords > 4) && (countWords < 9) && TextFormatter.hasPalindrome(sentence)) {
                    System.out.println(sentence);
                }
            }

        }


    }
}
