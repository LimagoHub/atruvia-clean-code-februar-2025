package generator.inner.generic;

import generator.IntGenerator;

import java.util.function.Function;

public class GenericIntGenerator implements IntGenerator {


    private int value;
    private final Function<Integer, Integer> function;

    public GenericIntGenerator(final Function<Integer, Integer> function, final int seed) {
        this.function = function;
        this.value = seed;
    }

    @Override
    public int next() {
        int result = value;
        value = function.apply(value);
        return result;
    }
}
