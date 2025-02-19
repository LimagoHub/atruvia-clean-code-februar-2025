package bootstrap;

import client.Client;
import client.inner.ClientImpl;
import container.IntArrayFactory;
import container.inner.builder.IntArrayFactoryBuilder;

import generator.IntGeneratorFactory;
import generator.inner.random.RandomNumberGeneratorFactory;

public class Bootstrap {

    public void startApplication() {
        for (int threadCount = 0; threadCount <= Runtime.getRuntime().availableProcessors() + 1; threadCount++) {
            run(threadCount);
        }

    }

    private static void run(final int threadCount) {
        System.out.println("Starting with " + threadCount + " threads...");
        Client client = createClient(threadCount);
        client.doSomethingWithLargeArray();
    }

    private static IntGeneratorFactory createIntGeneratorFactory() {
        return new RandomNumberGeneratorFactory();

    }

    private static IntArrayFactory createIntArrayFactory(final int threadCount) {
        IntArrayFactoryBuilder.threadCount = threadCount;
        IntArrayFactoryBuilder.benchmark = true;
        return IntArrayFactoryBuilder.createIntArrayFactory(createIntGeneratorFactory());
    }

    private static Client createClient(final int threadCount) {

        return new ClientImpl(createIntArrayFactory(threadCount));
    }
}
