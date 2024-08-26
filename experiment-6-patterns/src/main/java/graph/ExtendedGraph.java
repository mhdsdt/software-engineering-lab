package graph;

import route.OneWayState;
import route.Route;
import route.TwoWayState;
import transport.TrainStrategy;

import java.util.ArrayList;

public class ExtendedGraph extends Graph {
    private final Route route;

    public ExtendedGraph(ArrayList<Node> graph) {
        super(graph);
        this.route = new Route(new TwoWayState());
    }

    public void makeAllRoutesOneWay() {
        for (Node node : getGraph()) {
            for (Edge edge : node.getEdges()) {
                route.setState(new OneWayState());
                route.changeDirection(edge);
            }
        }
    }

    public void makeAllRoutesTwoWay() {
        for (Node node : getGraph()) {
            for (Edge edge : node.getEdges()) {
                route.setState(new TwoWayState());
                route.changeDirection(edge);
            }
        }
    }

    public void changeTrainUnitTime(TrainStrategy trainStrategy, int newUnitTime) {
        trainStrategy.setUnitTime(newUnitTime);
    }
}

