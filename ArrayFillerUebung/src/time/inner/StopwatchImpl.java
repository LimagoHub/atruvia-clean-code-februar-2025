package time.inner;

import time.Stopwatch;

import java.time.Duration;
import java.time.Instant;

public class StopwatchImpl implements Stopwatch {

    private Instant start, end;

    public StopwatchImpl() {
        start = end = Instant.now();
    }

    @Override
    public void start() {
        start = Instant.now();
    }

    @Override
    public void stop() {
        end = Instant.now();
    }

    @Override
    public Duration getElapsedTime() {
        return Duration.between(start, end);
    }
}
