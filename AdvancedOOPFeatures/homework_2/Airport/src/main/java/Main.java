import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final int MILLS_IN_HOURS = 7_200_000;
    public static void main(String[] args) {

        System.out.println(findPlanesLeavingInTheNextTwoHours(Airport.getInstance()));

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        ArrayList<Terminal> terminal = new ArrayList<>(airport.getTerminals());

        ArrayList<Flight> flights = new ArrayList<>();

        List<Flight> foundFlights;

        terminal.forEach(t -> flights.addAll(t.getFlights()));
        foundFlights = flights.stream().filter(Main::planesLeavingInTheNextTwoHoursFilter).collect(Collectors.toList());

        return foundFlights;
    }

    public static boolean planesLeavingInTheNextTwoHoursFilter(Flight flight) {

        Date currentDate = new Date();

        long timeDifference = (flight.getDate().getTime() - currentDate.getTime());

        return timeDifference <= MILLS_IN_HOURS && timeDifference > 0 && flight.getType() == Flight.Type.DEPARTURE;
    }

}