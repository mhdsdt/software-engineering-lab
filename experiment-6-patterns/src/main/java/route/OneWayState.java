package route;

import graph.Edge;

public class OneWayState implements RouteState {
    @Override
    public void setDirection(Edge edge) {
        edge.setDirected(true);
    }
}
