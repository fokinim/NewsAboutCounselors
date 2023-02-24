import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.nio.file.Paths;
import java.util.ArrayList;
public class JsonBuilder {

    public static final String JSON_STATION_FILEPATH = "FilesAndNetwork/DataCollector/src/main/resources/station.json";
    public static final String JSON_METRO_FILEPATH = "FilesAndNetwork/DataCollector/src/main/resources/metro.json";
    public static ArrayList<Station> stations = new ArrayList<>();
    public static ArrayList<Line> lines = new ArrayList<>();

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station getStation(String name) {

        name = name.toLowerCase().replace("ё", "е");

        for (Station station : stations) {
            String stationName = station.getName().toLowerCase().replace("ё", "е");
            if (stationName.equals(name)) {
                return station;
            }
        }
        return null;
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void writeJsonStationFile() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("stations", stations);

            writer.writeValue(Paths.get(JSON_STATION_FILEPATH).toFile(), jsonObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void writeJsonMetroFile() {

        ArrayList<String> linesNumbers = new ArrayList<>();

        for (Line line : lines) {
            linesNumbers.add(line.getNumber());
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            ObjectWriter writer = mapper.writer(prettyPrinter);

            JSONObject jsonObject = new JSONObject();
            JSONObject jsonObjectStations = new JSONObject();

            for (String lineNumber : linesNumbers) {
                JSONArray jsonArray = new JSONArray();
                for (Station station : stations) {
                    if (station.getLine().equals(lineNumber)) {
                        jsonArray.add(station.getName());
                    }
                }
                jsonObjectStations.put(lineNumber,jsonArray);
            }

            jsonObject.put("stations", jsonObjectStations);
            jsonObject.put("lines", lines);

            writer.writeValue(Paths.get(JSON_METRO_FILEPATH).toFile(), jsonObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
