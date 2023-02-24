import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DataParserHtml {

    public void htmlParser(String url) {

        try {

            int j = -1;
            Document doc = Jsoup.connect(url).get();
            Elements stations = doc.select("p.single-station");
            Elements lines = doc.select("span.js-metro-line");


            for (int i = 0; i < stations.size(); i++) {

                boolean hasConnection = stations.get(i).childrenSize() > 2;

                String[] stationName = stations.get(i).text().split("\\. ");

                if (stationName[0].equals("1")) {
                    j += 1;
                    Line line = new Line(lines.get(j).text(), lines.get(j).attr("data-line"));
                    JsonBuilder.addLine(line);
                }

                Station station = new Station(stationName[1],
                        lines.get(j).attr("data-line"), hasConnection);
                JsonBuilder.addStation(station);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
