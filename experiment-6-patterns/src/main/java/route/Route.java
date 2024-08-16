package route;

import graph.Edge;
import lombok.Setter;

@Setter
public class Route {
    private RouteState state;

    public Route(RouteState state) {
        this.state = state;
    }

    public void changeDirection(Edge edge) {
        state.setDirection(edge);
    }

}

