package transport;

public class BusStrategy implements TransportStrategy {
    @Override
    public int calculateTime(int baseTime) {
        return baseTime;
    }
}
