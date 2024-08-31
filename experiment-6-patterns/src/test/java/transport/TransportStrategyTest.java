package transport;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TransportStrategyTest {

    @Test
    public void testTrainStrategyDefaultUnitTime() {
        TrainStrategy trainStrategy = new TrainStrategy();
        int result = trainStrategy.calculateTime(10);
        assertEquals("Train strategy should return the default unit time of 1", 1, result);
    }

    @Test
    public void testTrainStrategyCustomUnitTime() {
        TrainStrategy trainStrategy = new TrainStrategy();
        trainStrategy.setUnitTime(5);
        int result = trainStrategy.calculateTime(10);
        assertEquals("Train strategy should return the custom unit time", 5, result);
    }

    @Test
    public void testBusStrategy() {
        BusStrategy busStrategy = new BusStrategy();
        int result = busStrategy.calculateTime(10);
        assertEquals("Bus strategy should return the base time given", 10, result);
    }
}

