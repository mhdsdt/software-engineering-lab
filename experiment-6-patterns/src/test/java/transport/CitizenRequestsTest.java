package transport;

import graph.*;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class CitizenRequestsTest {

    @Test
    public void testGetTimeByTrain() {
        Node cityA = new Node();
        Node cityB = new Node();
        Edge.createEdge(cityA, cityB, false, 3);

        ArrayList<Node> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        Graph graph = new Graph(cities);

        TrainStrategy trainStrategy = new TrainStrategy();
        CitizenRequests requests = new CitizenRequests(graph);

        int result = requests.getTimeByTrain(cityA, cityB, trainStrategy);
        assertEquals("Train time should be 1 unit by default", 1, result);
    }

    @Test
    public void testGetTimeByBus() {
        Node cityA = new Node();
        Node cityB = new Node();
        Edge.createEdge(cityA, cityB, false, 3);

        ArrayList<Node> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        Graph graph = new Graph(cities);

        BusStrategy busStrategy = new BusStrategy();
        CitizenRequests requests = new CitizenRequests(graph);

        int result = requests.getTimeByBus(cityA, cityB, busStrategy);
        assertEquals("Bus time should equal the weight of the edge", 3, result);
    }

    @Test
    public void testGetFasterTransport() {
        Node cityA = new Node();
        Node cityB = new Node();
        Edge.createEdge(cityA, cityB, false, 3);

        ArrayList<Node> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        Graph graph = new Graph(cities);

        TrainStrategy trainStrategy = new TrainStrategy();
        BusStrategy busStrategy = new BusStrategy();
        CitizenRequests requests = new CitizenRequests(graph);

        String result = requests.getFasterTransport(cityA, cityB, trainStrategy, busStrategy);
        assertEquals("Train should be faster by default", "Train", result);
    }

    @Test
    public void testCanTravelWithoutDislikedCity() {
        Node cityA = new Node();
        Node cityB = new Node();
        Node cityC = new Node();
        Edge.createEdge(cityA, cityB, false, 3);
        Edge.createEdge(cityB, cityC, false, 3);

        ArrayList<Node> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        cities.add(cityC);
        Graph graph = new Graph(cities);

        CitizenRequests requests = new CitizenRequests(graph);
        boolean result = requests.canTravelWithoutDislikedCity(cityA, cityC, cityB);

        assertFalse("It should not be possible to travel from city A to city C without passing through city B", result);
    }
}
