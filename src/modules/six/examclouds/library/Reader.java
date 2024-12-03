package modules.six.examclouds.library;


/*
ФИО,
номер читательского билета,
факультет,
дата рождения,
телефон.
Методы takeBook(), returnBook().
 */

import java.time.LocalDate;

public class Reader {

    private String fullName;
    private int idTicket;
    private String faculty;
    private LocalDate birthdate;
    private String phone;

    public Reader(String fullName, int idTicket, String faculty, LocalDate birthdate, String phone) {
        this.fullName = fullName;
        this.idTicket = idTicket;
        this.faculty = faculty;
        this.birthdate = birthdate;
        this.phone = phone;
    }

    private String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private int getIdTicket() {
        return idTicket;
    }

    private void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    private String getFaculty() {
        return faculty;
    }

    private void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String takeBook(int n) {
        String str = fullName + " взял " + n + " книг";
        if ((n % 10 == 1) && (n % 100 != 11)) {
            return str + "у";
        } else if ((n % 10 > 1) && (n % 10 < 5) && ((n % 100 > 20) || (n % 100 < 10))) {
            return str + "и";
        } else
            return str;
    }

    public String takeBook(String... books) {
        StringBuilder sb = new StringBuilder();
        sb.append(fullName).append(" взял книги:");
        for (String book : books) {
            sb.append(" ").append(book).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String takeBook(Book... books) {
        StringBuilder sb = new StringBuilder();
        sb.append(fullName).append(" взял книги:");
        for (Book book : books) {
            sb.append(" ").append(book.getBookName()).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String returnBook(int n) {
        String str = fullName + " вернул " + n + " книг";
        if ((n % 10 == 1) && (n % 100 != 11)) {
            return str + "у";
        } else if ((n % 10 > 1) && (n % 10 < 5) && ((n % 100 > 20) || (n % 100 < 10))) {
            return str + "и";
        } else
            return str;
    }

    public String returnBook(String... books) {
        StringBuilder sb = new StringBuilder();
        sb.append(fullName).append(" вернул книги:");
        for (String book : books) {
            sb.append(" ").append(book).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String returnBook(Book... books) {
        StringBuilder sb = new StringBuilder();
        sb.append(fullName).append(" вернул книги:");
        for (Book book : books) {
            sb.append(" ").append(book.getBookName()).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
