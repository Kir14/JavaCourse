package modules.nine.homework.files;

/*
Напишите программу. Она должна:
•	получать через консоль путь от пользователя до папки;
•	суммировать размер файлов папки и вложенных папок;
•	выводить полученную сумму файлов в удобочитаемом виде — в байтах, килобайтах, мегабайтах или гигабайтах;
•	программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).

 */

import java.io.File;
import java.util.Scanner;

public class CountSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        for (; ; ) {
            try {
                System.out.println("Enter folder:");
                line = scanner.nextLine();
                double folderSize;

                File dir = new File(line);
                if (!dir.exists()) {
                    throw new NullPointerException("No found folder");
                }
                folderSize = folderSize(dir);

                int count = 0;
                for (; folderSize > 1024; folderSize /= 1024, count++) ;
                String size = switch (count) {
                    case 0 -> "bytes";
                    case 1 -> "KB";
                    case 2 -> "MB";
                    case 3 -> "GB";
                    case 4 -> "TB";
                    default -> "";
                };
                System.out.println("The size of the " + line + " is " + String.format("%.1f", folderSize) + " " + size);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static double folderSize(File folder) {
        File[] files = folder.listFiles();
        double folderSize = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                folderSize += folderSize(file);
            } else {
                folderSize += file.length();
            }
        }
        return folderSize;
    }
}
