package bootstrap;

import client.Client;
import client.inner.ClientImpl;
import container.IntArrayFactory;
import container.inner.decorator.IntArrayFactoryBenchmarkDecorator;
import container.inner.sequential.IntArrayFactorySequentialImpl;
import generator.IntGenerator;

import generator.inner.generic.GenericIntGenerator;
import generator.inner.random.RandomNumberGenerator;
import time.inner.StopwatchImpl;

public class Bootstrap {

    public void startApplication() {
        for (int threadCount = 1; threadCount <= Runtime.getRuntime().availableProcessors() + 1; threadCount++) {
            run(threadCount);
        }

    }

    private static void run(final int threadCount) {
        Client client = createClient();
        client.doSomethingWithLargeArray();
    }

    private static IntGenerator createIntGenerator() {
        return new RandomNumberGenerator();
        //return new GenericIntGenerator(x->x+2, 0);
    }

    private static IntArrayFactory createIntArrayFactory() {
        IntArrayFactory result = new IntArrayFactorySequentialImpl(createIntGenerator());
        result = new IntArrayFactoryBenchmarkDecorator(result, new StopwatchImpl());
        return result;
    }

    private static Client createClient() {

        return new ClientImpl(createIntArrayFactory());
    }
}
