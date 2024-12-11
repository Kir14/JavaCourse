package modules.four.regexp.scr.fio;

public class Client {

    private String surname;
    private String name;
    private String middleName;

    public Client(String line) {
        line = line.trim();
        String[] mas = line.split("\\s");
        surname = mas[0];
        name = mas[1];
        middleName = mas[2];
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname + "\nИмя: " + name + "\nОтчество: " + middleName;
    }
}
