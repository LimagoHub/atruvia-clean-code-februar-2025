package container.inner.builder;

import container.IntArrayFactory;

import container.inner.decorator.IntArrayFactoryBenchmarkDecorator;
import container.inner.parallel.IntArrayFactoryAutoImpl;
import container.inner.parallel.IntArrayFactoryParallelImpl;
import container.inner.sequential.IntArrayFactorySequentialImpl;
import generator.IntGenerator;
import generator.IntGeneratorFactory;
import time.inner.StopwatchImpl;

public class IntArrayFactoryBuilder {

    public static int threadCount = 1;
    public static boolean benchmark = false;


    public static IntArrayFactory createIntArrayFactory(final IntGeneratorFactory generatorFactory) {
        IntArrayFactory result;
        switch (threadCount) {
            case 0-> result = new IntArrayFactoryAutoImpl(generatorFactory.createIntGenerator());
            case 1 -> result = new IntArrayFactorySequentialImpl(generatorFactory.createIntGenerator());
            default -> result = new IntArrayFactoryParallelImpl(generatorFactory, threadCount);
        }

        if(benchmark) result = new IntArrayFactoryBenchmarkDecorator(result, new StopwatchImpl());
        return result;
    }
}
