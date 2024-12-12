package modules.seven.lambda.src;

/*
Сделайте сортировку сотрудников одновременно по заработной плате и алфавиту.
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static String staffFile = "src/main/java/modules/seven/lambda/data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        staff.forEach(System.out::println);
        System.out.println();
        System.out.println("-----After sort---");
        staff.sort((o1, o2) -> {
            int comp = o1.getSalary().compareTo(o2.getSalary());
            if (comp == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return comp;
        });
        staff.forEach(System.out::println);

    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}