package seven.metro;

import junit.framework.Assert;
import junit.framework.TestCase;
import modules.eight.metro.RouteCalculator;
import modules.eight.metro.StationIndex;
import modules.eight.metro.core.Line;
import modules.eight.metro.core.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();


        route = new ArrayList<>();
        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        Station hello = new Station("Hello", line1);
        Station world = new Station("world", line1);
        Station java = new Station("Java", line1);

        Station y = new Station("Y", line2);
        Station e = new Station("E", line2);
        Station p = new Station("P", line2);


        Station py = new Station("Py", line3);
        Station by = new Station("By", line3);
        Station ru = new Station("ru", line3);

        stationIndex.addStation(hello);
        stationIndex.addStation(world);
        stationIndex.addStation(java);

        stationIndex.addStation(y);
        stationIndex.addStation(e);
        stationIndex.addStation(p);

        stationIndex.addStation(py);
        stationIndex.addStation(by);
        stationIndex.addStation(ru);

        stationIndex.addConnection(List.of(java, e));
        stationIndex.addConnection(List.of(e, java));

        stationIndex.addConnection(List.of(p, py));
        stationIndex.addConnection(List.of(py, p));

        line1.addStation(hello);
        line1.addStation(world);
        line1.addStation(java);

        line2.addStation(y);
        line2.addStation(e);
        line2.addStation(p);

        line3.addStation(py);
        line3.addStation(by);
        line3.addStation(ru);
    }

    public void testGetRouteOnTheLine() {
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Hello", 1),
                stationIndex.getStation("Java", 1));
        List<Station> expectedRoute = List.of(
                stationIndex.getStation("Hello", 1),
                stationIndex.getStation("world", 1),
                stationIndex.getStation("Java", 1)
        );
        Assert.assertEquals(expectedRoute, actualRoute);
        double actualDuration = RouteCalculator.calculateDuration(actualRoute);
        double expectedDuration = 5;
        Assert.assertEquals(expectedDuration, actualDuration);
    }

    public void testGetRouteOnTheLineOneStation() {
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Hello", 1),
                stationIndex.getStation("Hello", 1));
        List<Station> expectedRoute = List.of(
                stationIndex.getStation("Hello", 1)
        );
        Assert.assertEquals(expectedRoute, actualRoute);
        double actualDuration = RouteCalculator.calculateDuration(actualRoute);
        double expectedDuration = 0;
        Assert.assertEquals(expectedDuration, actualDuration);
    }

    public void testGetRouteWithOneConnection() {
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Hello", 1),
                stationIndex.getStation("P", 2));
        List<Station> expectedRoute = List.of(
                stationIndex.getStation("Hello", 1),
                stationIndex.getStation("world", 1),
                stationIndex.getStation("Java", 1),
                stationIndex.getStation("E", 2),
                stationIndex.getStation("P", 2)
        );
        Assert.assertEquals(expectedRoute, actualRoute);
        double actualDuration = RouteCalculator.calculateDuration(actualRoute);
        double expectedDuration = 11;
        Assert.assertEquals(expectedDuration, actualDuration);
    }

    public void testGetRouteWithOneConnectionTwoStation() {
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Java", 1),
                stationIndex.getStation("E", 2));
        List<Station> expectedRoute = List.of(
                stationIndex.getStation("Java", 1),
                stationIndex.getStation("E", 2)
        );
        Assert.assertEquals(expectedRoute, actualRoute);
        double actualDuration = RouteCalculator.calculateDuration(actualRoute);
        double expectedDuration = 3.5;
        Assert.assertEquals(expectedDuration, actualDuration);
    }

    public void testGetRouteWithTwoConnections() {
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Hello", 1),
                stationIndex.getStation("By", 3));
        List<Station> expectedRoute = List.of(
                stationIndex.getStation("Hello", 1),
                stationIndex.getStation("world", 1),
                stationIndex.getStation("Java", 1),
                stationIndex.getStation("E", 2),
                stationIndex.getStation("P", 2),
                stationIndex.getStation("Py", 3),
                stationIndex.getStation("By", 3)
        );
        Assert.assertEquals(expectedRoute, actualRoute);
        double actualDuration = RouteCalculator.calculateDuration(actualRoute);
        double expectedDuration = 17;
        Assert.assertEquals(expectedDuration, actualDuration);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
