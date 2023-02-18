import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex = new StationIndex();
    List<Station> connection1to2 = new ArrayList<>();
    List<Station> connection2to3 = new ArrayList<>();

    @Override
    protected void setUp() throws Exception {

        route = new ArrayList<>();

        Line line1 = new Line(1, "Первая линия");
        Line line2 = new Line(2, "Вторая линия");
        Line line3 = new Line(3, "Третья линия");

        Station station11 = new Station("Первоапрельская", line1);
        Station station12 = new Station("Первомайская", line1);
        Station station13 = new Station("Первоиюньская", line1);
        Station station21 = new Station("Второянварская", line2);
        Station station22 = new Station("Второфевральская", line2);
        Station station23 = new Station("Второмартовская", line2);
        Station station31 = new Station("Третьесентябрьская", line3);
        Station station32 = new Station("Третьеноябрьская", line3);
        Station station33 = new Station("Третьедекабрьская", line3);

        List<Station> allStations = new ArrayList<>();

        allStations.add(station11);
        allStations.add(station12);
        allStations.add(station13);
        allStations.add(station21);
        allStations.add(station22);
        allStations.add(station23);
        allStations.add(station31);
        allStations.add(station32);
        allStations.add(station33);

        route.addAll(allStations);

        for(int i = 0; i < allStations.size(); i++) {
            stationIndex.addStation(allStations.get(i));
            if (i < 3) {
                line1.addStation(allStations.get(i));
            } else if (i > 2 && i < 6) {
                line2.addStation(allStations.get(i));
            } else if (i > 5) {
                line3.addStation(allStations.get(i));
            }
        }

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        connection1to2.add(station13);
        connection1to2.add(station21);

        connection2to3.add(station23);
        connection2to3.add(station31);

        stationIndex.addConnection(connection1to2);
        stationIndex.addConnection(connection2to3);

    }

    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22.0;

        assertEquals(expected, actual);

    }

    public void testGetShortestRoute() {

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Первоапрельская"),
                stationIndex.getStation("Третьедекабрьская"));

        List<Station> expected = route;

        assertEquals(expected, actual);

    }
}
