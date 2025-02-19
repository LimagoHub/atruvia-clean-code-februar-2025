package container.inner.decorator;

import container.IntArrayFactory;
import time.Stopwatch;

public class IntArrayFactoryBenchmarkDecorator implements IntArrayFactory {

    private final IntArrayFactory intArrayFactory;
    private final Stopwatch stopwatch;

    public IntArrayFactoryBenchmarkDecorator(final IntArrayFactory intArrayFactory, final Stopwatch stopwatch) {
        this.intArrayFactory = intArrayFactory;
        this.stopwatch = stopwatch;
    }

    public int[] createAndFillArray(final int size) {
        stopwatch.start();
        var result = intArrayFactory.createAndFillArray(size);
        stopwatch.stop();
        System.out.println("Duration : " + stopwatch.getElapsedTime().toMillis() + " milliseconds");
        return result;
    }
}
