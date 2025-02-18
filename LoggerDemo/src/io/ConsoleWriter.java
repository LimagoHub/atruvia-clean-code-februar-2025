package io;

public class ConsoleWriter implements Writer {
    @Override
    public void write(final String text) {
        System.out.println();
    }
}
