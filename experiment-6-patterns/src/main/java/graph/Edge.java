package graph;

import lombok.Setter;
import org.javatuples.Pair;

import lombok.Getter;

@Getter
public class Edge {
    private final Pair<Node, Node> nodes;
    @Setter
    private boolean directed;
    private final int weight;

    public Edge(Node a, Node b, boolean directed, int weight) {
        nodes = new Pair<>(a, b);
        this.directed = directed;
        this.weight = weight;
    }

    public static Edge createEdge(Node a, Node b, boolean directed, int weight) {
        Edge newEdge = new Edge(a, b, directed, weight);
        a.getEdges().add(newEdge);
        b.getEdges().add(newEdge);
        return newEdge;
    }
}
