package modules.nine.homework.folders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Folder {

    /*
    Копирование папки с полной структурой
     */
    public static void copyTo(Path pathFrom, Path pathTo) {
        try {
            if (Files.isDirectory(pathFrom)) {
                pathTo = Paths.get(pathTo + "\\" + pathFrom.getFileName());
                Files.createDirectories(pathTo);
                copy(pathFrom, pathTo);
            } else {

                Files.createDirectories(pathTo);
                Files.copy(pathFrom, Paths.get(pathTo + "\\" + pathFrom.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(Path pathFrom, Path pathTo) {
        try {
            if (Files.isDirectory(pathFrom)) {

                if (Files.notExists(pathFrom)) {
                    throw new NullPointerException();
                }

                if (Files.notExists(pathTo)) {
                    Files.createDirectories(pathTo);
                }

                try (Stream<Path> files = Files.list(pathFrom)) {
                    files.forEach(file -> copy(file, pathTo.resolve(pathFrom.relativize(file))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Files.copy(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
