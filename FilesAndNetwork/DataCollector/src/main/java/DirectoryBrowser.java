import java.io.File;
import java.util.ArrayList;

public class DirectoryBrowser {

    private ArrayList<File> allFiles = new ArrayList<>();
    public ArrayList<File> browsDirectory(String path, String extension) {

        ArrayList<File> requiredFiles = new ArrayList<>();
        File directory = new File(path);

        File[] files = directory.listFiles();

        requiredFiles.addAll(directoryStructure(files, extension));

        allFiles.clear();

        return requiredFiles;
    }

    private ArrayList<File> directoryStructure(File[] files, String extension) {

        for (File file : files) {
            if (file.isDirectory()) {
                File[] files1 = file.listFiles();
                directoryStructure(files1, extension);
            } else if (file.getName().endsWith(extension)){
                allFiles.add(file);
            }
        }
        return allFiles;
    }
}
