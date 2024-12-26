package modules.nine.homework.movements;

import lombok.Getter;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ParserMovements {

    public HashMap<String, Double> organisations;

    @Getter
    private Path path;

    @Getter
    private double credit;

    @Getter
    private double debit;

    public ParserMovements(String path) {
        this.path = Paths.get(path);
        organisations = new HashMap<>();
        getData();
        System.out.println();
    }

    private void getData() {
        if (Files.notExists(path)) {
            throw new NullPointerException("No found file");
        }
        credit = 0;
        debit = 0;
        organisations.clear();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                line = modifyLine(line);
                String[] arr = line.split(",");
                if (!arr[7].equals("0")) {
                    putCreditOperation(arr);
                }
                debit += Double.parseDouble(arr[6]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
    ',' is replaced by '.' in digit in "", delete '*' from line,
     */
    private String modifyLine(String line) {
        int indexStart = line.indexOf("\"");
        while (indexStart != -1) {
            int indexEnd = line.indexOf("\"", indexStart + 1);

            String tmp = line.substring(indexStart + 1, indexEnd);
            String tmpNew = tmp.replaceAll(",", ".");
            line = line.replace("\"" + tmp + "\"", tmpNew);
            indexStart = line.indexOf("\"");
        }
        return line;
    }

    private void putCreditOperation(String[] arr) {
        double creditOperation = Double.parseDouble(arr[7]);
        credit += creditOperation;
        String nameOrganisation = getNameOrganisation(arr[5]);
        if (organisations.containsKey(nameOrganisation)) {
            organisations.put(nameOrganisation, organisations.get(nameOrganisation) + creditOperation);
        } else {
            organisations.put(nameOrganisation, creditOperation);
        }
    }

    private String getNameOrganisation(String descriptionString) {
        String[] description = descriptionString.split("\\s+");
        int count = 0;
        for (; ; ) {
            DateFormat sdf = new SimpleDateFormat("dd.MM.yy");
            sdf.setLenient(false);
            try {
                sdf.parse(description[count]);
            } catch (Exception e) {
                count++;
                continue;
            }
            break;
        }
        return Arrays.stream(description)
                .limit(count)
                .skip(1)
                .map(line -> { //Get short organisation name
                    String[] parts = line.split("\\\\");
                    line = parts[parts.length - 1];
                    return line;
                })
                .collect(Collectors.joining(" "));
    }


}
