package modules.nine.homework.html;

/*
Напишите программу, которая:
•	получает с помощью библиотеки jsoup HTML-код страницы https://lenta.ru;
•	находит в HTML-коде теги img и получает абсолютные ссылки на изображения из атрибута src;
•	скачивает изображения в папку images проекта, при этом сохраняя оригинальные названия файлов;
•	выводит в консоль список c названиями скачанных файлов.
Рекомендации
•	Все варианты подключения библиотеки jsoup в проект на странице скачивания библиотеки
•	Для получения ссылок воспользуйтесь префиксом abs при получении атрибута src у тега img. Пример из официальной документации.

 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainHtml {
    public static void main(String[] args) {
        Document doc = null;
        /*try {
            doc = Jsoup.connect("https://music.yandex.ru/home").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        try {
            doc = Jsoup.parse(new File("src/main/java/modules/nine/homework/html/data/site.html"), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements imgs = doc.select("img");
        int count = 0;
        for (Element img : imgs) {
            System.out.println(img.attr("src"));
            /*try {
                downloadImage(img.attr("src"), "folder" + count + ".jpg");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
            count++;
        }
    }

    private static void downloadImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL("https:" + imageUrl);
        try (InputStream in = url.openStream();
             OutputStream out = Files.newOutputStream(Paths.get(destinationFile))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Image downloaded to: " + destinationFile);
        }
    }
}
