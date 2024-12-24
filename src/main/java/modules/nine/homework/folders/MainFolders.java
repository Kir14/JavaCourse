package modules.nine.homework.folders;

import java.nio.file.Paths;

public class MainFolders {
    public static void main(String[] args) {
        Folder.copyTo(Paths.get("C:\\Users\\kaleichyk_k\\IdeaProjects\\JavaCourse\\src\\main\\java\\modules\\nine\\homework\\files\\folder"),
                Paths.get("C:\\Users\\kaleichyk_k\\IdeaProjects\\JavaCourse\\src\\main\\java\\modules\\nine\\homework\\folders\\testFiles"));
    }
}
