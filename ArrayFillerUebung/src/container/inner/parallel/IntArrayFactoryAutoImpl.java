package container.inner.parallel;

import container.AbstractIntArrayFactory;
import container.IntArrayFactory;
import generator.IntGenerator;

import java.util.Arrays;

public class IntArrayFactoryAutoImpl extends AbstractIntArrayFactory{

    private final IntGenerator generator;

    public IntArrayFactoryAutoImpl(final IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    protected void fill() {
       
    }
}
