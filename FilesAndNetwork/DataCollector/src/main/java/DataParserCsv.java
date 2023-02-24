import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataParserCsv {
    public static final String REGEX_DATE = "\\d{2}\\.\\d{2}\\.\\d{4}";
    public void csvParser(String path) {

        try {

            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                String[] fragments = line.split(",");
                String stationName = fragments[0];
                String date = fragments[1];
                Station station = JsonBuilder.getStation(stationName);

                if (date.matches(REGEX_DATE) && station != null && station.getDate() == null) {

                    station.setDate(fragments[1]);

                } else if (date.matches(REGEX_DATE) && station == null) {
                    System.err.println("Станция не найдена, дата не установлена: " + fragments[0]); // временный код
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
