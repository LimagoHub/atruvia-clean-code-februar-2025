package client.inner;

import client.Client;
import container.IntArrayFactory;

public class ClientImpl implements Client {


    private final IntArrayFactory factory;

    public ClientImpl(final IntArrayFactory factory) {
        this.factory = factory;
    }

    @Override
    public void doSomethingWithLargeArray() {

        int []data = factory.createAndFillArray(Integer.MAX_VALUE / 2);
        for (int i = 0; i < 3; i++) {
            System.out.println(data[i]);
        }
    }
}
