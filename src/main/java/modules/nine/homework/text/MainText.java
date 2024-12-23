package modules.nine.homework.text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MainText {
    public static void main(String[] args) {

        System.out.println("\nВывод палиндромов:");
        /*
        1)В исходном файле находятся слова, каждое слово на новой стороке. После
        запуска программы должен создать файл, который будет содержать в себе
        только палиндромы
         */
        try {
            TextFormatter text = new TextFormatter("D:\\java\\test\\testJava.txt");
            text.getPalindromes("D:\\java\\test\\testJavaResult.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("\nТекст:");
        /*
        2)Текстовый файл содержит текст. После запуска программы в другой файл
         должны записаться только те предложения в которых от 3-х до 5-ти слов. Если в
         предложении присутствует слово-палиндром, то не имеет значения какое кол-во
         слов в предложении, оно попадает в новый файл.
         */

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("D:\\java\\test\\testJavaTextResult.txt"),
                StandardOpenOption.CREATE)) {
            TextFormatter textFormatter = new TextFormatter("D:\\java\\test\\testJavaText.txt");
            textFormatter.getSentences()
                    .forEach(topic -> {
                        Arrays.stream(topic)
                                .forEach(sentence -> {
                                    int countWords = TextFormatter.countWords(sentence);
                                    if (((countWords > 2) && (countWords < 6)) || TextFormatter.hasPalindrome(sentence)) {
                                        System.out.println(sentence);
                                        try {
                                            bw.write(sentence + "\n");
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                });
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        System.out.println("\nПроверка на цензуру:");
        /*
         3) Проверка на цензуру:
         Создаете 2 файла.
         1 - й. Содержит исходный текст.
         2 - й. Содержит слова недопустимые в тексте(black list). Структура файла
        определите сами, хотите каждое слово на новой строке, хотите через запятую
        разделяйте, ваша программа делайте как считаете нужным.
        Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не
        встретилось ни одного недопустимого слова, то выводите сообщение о том что
        текст прошёл проверку на цензуру. Если нет, то выводите соответствуюущее
        сообщение, кол-во предложений не прошедших проверку и сами предложения
        подлежащие исправлению.
         */
        try {
            Set<String> black = Files.readAllLines(Paths.get("D:\\java\\test\\blackList.txt")).stream()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());
            TextFormatter textFormatter = new TextFormatter("D:\\java\\test\\testJavaText.txt");
            ArrayList<String> errorSentences = new ArrayList<>();
            textFormatter.getSentences()
                    .forEach(topic -> Arrays.stream(topic)
                            .forEach(sentence -> {
                                String[] words = TextFormatter.getWords(sentence);
                                if (Arrays.stream(words).map(String::toLowerCase).anyMatch(black::contains)) {
                                    errorSentences.add(sentence);
                                }
                            }));
            if (errorSentences.isEmpty()) {
                System.out.println("Проверка пройдена");
            } else {
                System.out.println("Количество предложений с запрещенными словами " + errorSentences.size() + ":");
                errorSentences.forEach(System.out::println);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("\nСериализация");
        /*
        4) Сериализовать объект Автомобиль(Марка, скорость, цена). После
        сериализации произвести обратный процесс
         */
        Car bugatti = new Car();
        bugatti.setModel("Bugatti");
        bugatti.setSpeed(320);
        bugatti.setPrice(213431);

        Car ferrari = new Car("Ferrari", 320, 4327298.87);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(bugatti);
        cars.add(ferrari);
        cars.add(new Car("Lada", 120, 431));
        cars.add(new Car("Lada X Ray", 130, 651));

        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("D:\\java\\test\\serializeData.dat"))) {
            ois.writeObject(cars);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cars.clear();
        cars.forEach(System.out::println);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\java\\test\\serializeData.dat"))) {
            cars = (ArrayList<Car>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cars.forEach(System.out::println);


    }
}
