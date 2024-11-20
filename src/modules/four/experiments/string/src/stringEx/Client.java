package modules.four.experiments.string.src.stringEx;


public class Client {

    private String surname;
    private String name;
    private String middleName;

    public Client(String line) {
        line = line.trim();
        line += " ";
        String[] lines = new String[1];
        lines[0] = line;
        surname = parseLine(lines);
        name = parseLine(lines);
        middleName = parseLine(lines);

    }

    private String parseLine(String[] lines) {
        int spaceIndex = lines[0].indexOf(' ');
        if (spaceIndex != -1) {
            String result = lines[0].substring(0, spaceIndex + 1);
            lines[0] = lines[0].substring(spaceIndex + 1);
            return result;
        } else {
            return "";
        }
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
