package graph;

import lombok.Getter;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

@Getter
public class Graph {
    private final ArrayList<Node> graph;

    public Graph(ArrayList<Node> graph) {
        this.graph = graph;
    }

    public void resetVisits() {
        for (Node v : this.getGraph())
            v.setVisited(false);
    }

    public void bfs(Node s) {
        this.resetVisits();

        Queue<Pair<Node, Integer>> nodes = new LinkedList<>();
        nodes.add(new Pair<>(s, 0));
        while (!nodes.isEmpty()) {
            Pair<Node, Integer> front = nodes.poll();
            Node frontNode = front.getValue0();
            if (!frontNode.isVisited()) {
                frontNode.setVisited(true);
                int distance = front.getValue1();
                frontNode.setDistance(distance);
                nodes.addAll(frontNode.getAvailableNeighbors()
                        .stream()
                        .map(neighbor -> new Pair<Node, Integer>(neighbor, distance + 1))
                        .collect(Collectors.toCollection(ArrayList::new)));
            }
        }
    }

    public void bfsSkippingDislikedCity(Node start, Node dislikedCity) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        start.setVisited(true);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.getAvailableNeighbors()) {
                if (!neighbor.isVisited() && neighbor != dislikedCity) {
                    neighbor.setVisited(true);
                    neighbor.setDistance(current.getDistance() + 1);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dijkstra(Node s) {
        this.resetVisits();

        PriorityQueue<Pair<Integer, Node>> nodes = new PriorityQueue<>();
        nodes.add(new Pair<Integer, Node>(0, s));
        while (!nodes.isEmpty()) {
            Pair<Integer, Node> front = nodes.poll();
            Node frontNode = front.getValue1();
            if (!frontNode.isVisited()) {
                frontNode.setVisited(true);
                int distance = front.getValue0();
                frontNode.setDistance(distance);
                nodes.addAll(frontNode.getAvailableWeightedNeighbors()
                        .stream()
                        .map(neighbor -> new Pair<Integer, Node>(neighbor.getValue1() + distance,
                                neighbor.getValue0()))
                        .collect(Collectors.toCollection(PriorityQueue::new)));
            }
        }
    }

}