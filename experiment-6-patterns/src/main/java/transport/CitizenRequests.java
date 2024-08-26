package transport;

import graph.Graph;
import graph.Node;

public class CitizenRequests {
    private final Graph graph;

    public CitizenRequests(Graph graph) {
        this.graph = graph;
    }

    public int getTimeByTrain(Node start, Node end, TrainStrategy trainStrategy) {
        graph.bfs(start);
        return trainStrategy.calculateTime(end.getDistance());
    }

    public int getTimeByBus(Node start, Node end, BusStrategy busStrategy) {
        graph.dijkstra(start);
        return busStrategy.calculateTime(end.getDistance());
    }

    public String getFasterTransport(Node start, Node end, TrainStrategy trainStrategy, BusStrategy busStrategy) {
        int trainTime = getTimeByTrain(start, end, trainStrategy);
        int busTime = getTimeByBus(start, end, busStrategy);
        return trainTime < busTime ? "Train" : "Bus";
    }

    public boolean canTravelWithoutDislikedCity(Node start, Node end, Node dislikedCity) {
        dislikedCity.setVisited(true);
        graph.bfsSkippingDislikedCity(start, dislikedCity);
        return end.isVisited();
    }
}

