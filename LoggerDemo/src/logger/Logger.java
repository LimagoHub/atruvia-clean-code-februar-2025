package logger;

import io.Writer;

public class Logger {


    private final Writer writer;

    public Logger(final Writer writer) {
        this.writer = writer;
    }

    public void log(String message) {
        final String komplexerPraefix = "Prefix: ";
        writer.write(komplexerPraefix + message);
    }
}
