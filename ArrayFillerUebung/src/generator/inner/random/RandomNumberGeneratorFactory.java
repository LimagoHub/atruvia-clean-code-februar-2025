package generator.inner.random;

import generator.IntGenerator;
import generator.IntGeneratorFactory;

public class RandomNumberGeneratorFactory implements IntGeneratorFactory {

    @Override
    public IntGenerator createIntGenerator() {
        return new RandomNumberGenerator();
    }
}
