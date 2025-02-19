package container.inner.parallel;

import container.AbstractIntArrayFactory;
import generator.IntGenerator;
import generator.IntGeneratorFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IntArrayFactoryParallelImpl extends AbstractIntArrayFactory {

    private final IntGeneratorFactory generatorFactory;
    private final int numberOfThreads;
    private int segmentSize;
    private ExecutorService service;


    public IntArrayFactoryParallelImpl(final IntGeneratorFactory generatorFactory, final int numberOfThreads) {
        this.generatorFactory = generatorFactory;
        this.numberOfThreads = numberOfThreads;

    }

    @Override
    protected void fill() {
        calculateSegmentSize();
        initalizeExecutorService();
        startWorkerParallel();
        awaitTermination();
    }



    private void calculateSegmentSize() {
        segmentSize = getData().length / numberOfThreads;
    }
    private void initalizeExecutorService() {
        service = Executors.newFixedThreadPool(numberOfThreads);
    }

    private void startWorkerParallel() {
        for (int currentWorker = 0; currentWorker < numberOfThreads; currentWorker++) {
            startSingleWorker(currentWorker);
        }
    }

    private void awaitTermination() {
        try {
            tryAwaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void tryAwaitTermination() throws InterruptedException {
        service.shutdown();
        service.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startSingleWorker(final int currentWorker) {
        final int start = currentWorker * segmentSize;
        final int end = start + segmentSize;
        service.execute(new FillSegmentWorker(start, end));
    }

    private class FillSegmentWorker implements Runnable {

        private final int start;
        private final int end;

        public FillSegmentWorker(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            final int [] data = getData();
            final IntGenerator generator = generatorFactory.createIntGenerator();
            for (int i = start; i < end; i++) {
                data[i]=generator.next();
            }
        }
    }
}
