package route;

import graph.Edge;
import graph.Node;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RouteStateTest {

    @Test
    public void testOneWayState() {
        Node nodeA = new Node();
        Node nodeB = new Node();
        Edge edge = new Edge(nodeA, nodeB, false, 5);
        RouteState oneWayState = new OneWayState();

        oneWayState.setDirection(edge);
        assertTrue("Edge should be directed in one-way state", edge.isDirected());
    }

    @Test
    public void testTwoWayState() {
        Node nodeA = new Node();
        Node nodeB = new Node();
        Edge edge = new Edge(nodeA, nodeB, true, 5);
        RouteState twoWayState = new TwoWayState();

        twoWayState.setDirection(edge);
        assertFalse("Edge should be undirected in two-way state", edge.isDirected());
    }
}

