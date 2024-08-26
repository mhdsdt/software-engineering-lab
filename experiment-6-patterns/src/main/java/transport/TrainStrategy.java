package transport;

import lombok.Setter;

@Setter
public class TrainStrategy implements TransportStrategy {
    private int unitTime = 1;

    @Override
    public int calculateTime(int baseTime) {
        return unitTime;
    }
}
