import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataParserJson {
    public static String REGEX_DEPTH = "-?\\d{1,3}\\.?\\d{0,3}";
    public void jsonParser(String path){
       try {
           JSONParser parser = new JSONParser();
           JSONArray data = (JSONArray) parser.parse(getJsonFile(path));

           for (Object datum : data) {
               JSONObject stationData = (JSONObject) datum;
               String stationName = stationData.get("station_name").toString();
               String depth = stationData.get("depth").toString();
               depth = depth.replace(",", ".");

               if (!depth.matches(REGEX_DEPTH)) {
                   continue;
               }

               Station station = JsonBuilder.getStation(stationName);

               if (station != null && station.getDepth() != null) {

                   boolean depthsComparison = Float.parseFloat(station.getDepth()) < Float.parseFloat(depth);
                   station.setDepth(depthsComparison ? station.getDepth() : depth);

               } else if (station != null && station.getDepth() == null) {
                   station.setDepth(depth);

               } else if (station == null) {
                   System.err.println("Станция не найдена, глубина не установлена: " + stationName); // временный код
               }
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }
    }

    private static String getJsonFile(String path) {

        StringBuilder builder = new StringBuilder();

        try {

            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(builder::append);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}

