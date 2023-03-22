import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C://skillbox//src";
        String dstFolder = "C://skillbox//dst";

        try {
            File srcDir = new File(srcFolder);

            long start = System.currentTimeMillis();

            File[] files = srcDir.listFiles();

            int cores = Runtime.getRuntime().availableProcessors();
            int part = files.length / cores;
            int partCount = files.length / part;
            int currentPosition = 0;

            for (int i = 1; i <= partCount; i++) {

                int currentPart = i == partCount ? files.length - part * (i - 1) : part;

                File[] files1 = new File[currentPart];
                System.arraycopy(files, currentPosition, files1, 0, files1.length);
                ImageResizer resizer = new ImageResizer(files1, dstFolder, start);
                new Thread(resizer).start();
                currentPosition += currentPart;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
