package main;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final Random random = new Random();
        int [] data = new int [Integer.MAX_VALUE/2];

        Instant start = Instant.now();
        for(int i = 0; i < data.length; i++){
            data[i] = random.nextInt();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());

    }
}