package modules.six.examclouds.library;

import java.time.LocalDate;

public class MainLibrary {
    public static void main(String[] args) {
        Reader oleg = new Reader("Олег", 2123, "ФИТиУ", LocalDate.of(2000, 9,12),"357257546");

        for (int i = 0; i < 30; i++) {
            System.out.println(oleg.takeBook(i));
        }

        System.out.println(oleg.takeBook("Приключения", "Словарь", "Энциклопедия"));

        Book dictionary = new Book("Сергей Иванович Ожегов" , "Словарь русского языка");
        Book adv = new Book("Марк Твен", "Приключения Тома Сойера");

        System.out.println(oleg.takeBook(dictionary, adv));

        for (int i = 0; i < 30; i++) {
            System.out.println(oleg.returnBook(i));
        }

        System.out.println(oleg.returnBook("Приключения", "Словарь", "Энциклопедия"));

        System.out.println(oleg.returnBook(dictionary, adv));

    }
}
