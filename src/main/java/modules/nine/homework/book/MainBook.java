package modules.nine.homework.book;

import modules.nine.homework.book.parser.JsonParserBooks;
import modules.nine.homework.book.parser.XmlParserBooks;

import java.util.ArrayList;
import java.util.Arrays;

public class MainBook {
    public static void main(String[] args) {
        Book hp1 = new Book("Harry Potter 1", "123", 1991);
        Book hp2 = new Book("Harry Potter 2", "12415", 1996);
        Book hp3 = new Book("Harry Potter 3", "24353", 2000);
        Book hp4 = new Book("Harry Potter 4", "15526", 2002);
        Book hp5 = new Book("Harry Potter 5", "15523", 2004);

        hp1.series = new ArrayList<>(Arrays.asList(hp2, hp3, hp4, hp5));
        hp2.series = new ArrayList<>(Arrays.asList(hp1, hp3, hp4, hp5));
        hp3.series = new ArrayList<>(Arrays.asList(hp1, hp2, hp4, hp5));
        hp4.series = new ArrayList<>(Arrays.asList(hp1, hp2, hp3, hp5));
        hp5.series = new ArrayList<>(Arrays.asList(hp1, hp2, hp3, hp4));

        try {
            XmlParserBooks xml = new XmlParserBooks("src/main/java/modules/nine/homework/book/data/xmlBooks.xml");
            xml.addBookNode(hp1);
            xml.addBookNode(hp2);
            xml.addBookNode(hp3);
            xml.writeXml();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            JsonParserBooks json = new JsonParserBooks("src/main/java/modules/nine/homework/book/data/jsonBooks.json");
            json.addBook(hp1);
            json.addBook(hp2);
            json.addBook(hp3);
            json.writeJson();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
