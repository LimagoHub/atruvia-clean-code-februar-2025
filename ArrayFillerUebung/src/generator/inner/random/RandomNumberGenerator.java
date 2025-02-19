package generator.inner.random;


import generator.IntGenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class RandomNumberGenerator implements IntGenerator {

    private final Random random = new Random();
    @Override
    public int next() {
        //return random.nextInt();
        return ThreadLocalRandom.current().nextInt();
    }
}
