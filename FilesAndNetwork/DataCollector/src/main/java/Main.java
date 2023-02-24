import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String url = "https://skillbox-java.github.io/";

        DataParserHtml parserHtml = new DataParserHtml();
        DataParserCsv parserCsv = new DataParserCsv();
        DataParserJson parserJson = new DataParserJson();
        DirectoryBrowser browser = new DirectoryBrowser();
        ArrayList<File> csvFiles;
        ArrayList<File> jsonFiles;

        csvFiles = browser.browsDirectory("FilesAndNetwork/DataCollector/src/main/data", ".csv");
        jsonFiles = browser.browsDirectory("FilesAndNetwork/DataCollector/src/main/data", ".json");

        parserHtml.htmlParser(url);

        for (File file : csvFiles) {
            parserCsv.csvParser(file.getPath());
        }

        for (File file : jsonFiles) {
            parserJson.jsonParser(file.getPath());
        }

        JsonBuilder.writeJsonStationFile();
        JsonBuilder.writeJsonMetroFile();
    }
}
