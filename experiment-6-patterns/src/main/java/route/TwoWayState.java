package route;

import graph.Edge;

public class TwoWayState implements RouteState {
    @Override
    public void setDirection(Edge edge) {
        edge.setDirected(false);
    }
}
