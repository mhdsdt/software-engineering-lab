package graph;

import org.junit.Test;
import transport.TrainStrategy;

import java.util.ArrayList;

import static junit.framework.TestCase.*;


public class ExtendedGraphTest {

    @Test
    public void testMakeAllRoutesOneWay() {
        Node cityA = new Node();
        Node cityB = new Node();
        Edge edge = Edge.createEdge(cityA, cityB, false, 3);

        ArrayList<Node> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        ExtendedGraph graph = new ExtendedGraph(cities);

        graph.makeAllRoutesOneWay();

        assertTrue("All edges should be directed after calling makeAllRoutesOneWay", edge.isDirected());
    }

    @Test
    public void testMakeAllRoutesTwoWay() {
        Node cityA = new Node();
        Node cityB = new Node();
        Edge edge = Edge.createEdge(cityA, cityB, true, 3);

        ArrayList<Node> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        ExtendedGraph graph = new ExtendedGraph(cities);

        graph.makeAllRoutesTwoWay();

        assertFalse("All edges should be undirected after calling makeAllRoutesTwoWay", edge.isDirected());
    }

    @Test
    public void testChangeTrainUnitTime() {
        TrainStrategy trainStrategy = new TrainStrategy();
        ExtendedGraph graph = new ExtendedGraph(new ArrayList<>());

        graph.changeTrainUnitTime(trainStrategy, 5);

        assertEquals("Train unit time should be changed to 5", 5, trainStrategy.calculateTime(1));
    }
}
