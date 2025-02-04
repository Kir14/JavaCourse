package modules.nine.homework.book;

/*
Создать класс Книга
- артикул
- название
- год издания
- список книг из той-же серии(не названий книг, а Объектов книга)
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter

public class Book implements Serializable {
    private String article;
    private String name;
    private Integer year;
    public ArrayList<Book> series;

    public Book(String name, String article, int year) {
        this.article = article;
        this.name = name;
        this.year = year;
        series = new ArrayList<>();
    }

}
