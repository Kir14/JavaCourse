package modules.four.homework.src;

import java.io.*;
import java.util.ArrayList;

public class TextFormatter {

    private String pathFile;

    public TextFormatter(String pathFile) {
        this.pathFile = pathFile;
    }

    /*
    В исходном файле находятся слова, каждое слово на новой строке. После
    запуска программы должен создать файл, который будет содержать в себе
    только палиндромы
     */
    public void getPalindromes(String pathOutputFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(pathFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(pathOutputFile, false))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isPalindrome(line)) {
                    System.out.println(line);
                    bw.write(line + "\n");
                }
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String[]> getSentences() {
        ArrayList<String[]> sentences = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            sentences.add(br.readLine().split("[.!?]+\\s"));

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return sentences;
    }

    /*
    2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если
     есть возвращает true, если нет false
     */
    public static boolean hasPalindrome(String sentence) {
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            if (isPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

    /*
    1. Метод принимает строку и возвращает кол-во слов в строке.
     */
    public static int countWords(String sentence) {
        return sentence.split("\\s+").length;
    }

    public static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return word.equals(sb.toString());
    }


}
