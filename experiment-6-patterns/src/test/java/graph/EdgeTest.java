package graph;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class EdgeTest {

    @Test
    public void testSetDirected() {
        Node nodeA = new Node();
        Node nodeB = new Node();
        Edge edge = Edge.createEdge(nodeA, nodeB, false, 5);

        edge.setDirected(true);
        assertTrue("Edge should be directed after calling setDirected(true)", edge.isDirected());

        edge.setDirected(false);
        assertFalse("Edge should be undirected after calling setDirected(false)", edge.isDirected());
    }
}
