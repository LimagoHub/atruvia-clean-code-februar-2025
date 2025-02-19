package container;

import generator.IntGenerator;

public abstract class AbstractIntArrayFactory implements IntArrayFactory {






    @Override
    public final int[] createAndFillArray(final int size) {
        var data = new int[size];
        fill(data);
        return data;
    }

    protected abstract void fill(int [] data);
}
