package container.inner.sequential;

import container.AbstractIntArrayFactory;
import generator.IntGenerator;

public class IntArrayFactorySequentialImpl extends AbstractIntArrayFactory {

    private final IntGenerator generator;

    public IntArrayFactorySequentialImpl(final IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    protected void fill() {
        int [] data = getData();
        for (int i = 0; i < data.length; i++) {
            data[i] = generator.next();
        }
    }
}
