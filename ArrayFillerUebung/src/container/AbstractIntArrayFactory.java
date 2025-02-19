package container;

import generator.IntGenerator;

public abstract class AbstractIntArrayFactory implements IntArrayFactory {


    private int [] data;

    protected int[] getData() {
        return data;
    }

    public void setData(final int[] data) {
        this.data = data;
    }

    @Override
    public final int[] createAndFillArray(final int size) {
        data = new int[size];
        fill();
        return data;
    }

    protected abstract void fill();
}
