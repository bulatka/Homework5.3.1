import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File[] dirs = {new File("Games/savegames"),
                new File("Games/temp"),
                new File("Games/src/main"),
                new File("Games/src/test"),
                new File("Games/res/drawables"),
                new File("Games/res/vectors"),
                new File("Games/res/icons"),};
        File[] files = {new File("Games/src/main/Main.java"),
                new File("Games/src/main/Utils.java"),
                new File("Games/temp/temp.txt")};

        StringBuilder log = new StringBuilder();

        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].mkdirs()) {
                log.append("Создана директория: " + dirs[i].getPath() + "\n");
            }
        }

        for (int i = 0; i < files.length; i++) {
            try {
                if (files[i].createNewFile()) {
                    log.append("Создан файл: " + files[i].getAbsolutePath() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(log);
        try (FileWriter logWriter = new FileWriter("Games/temp/temp.txt")) {
            String s = log.toString();
            logWriter.append(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}