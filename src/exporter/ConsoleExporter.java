package exporter;

public class ConsoleExporter extends StreamTextExporter {
    public ConsoleExporter() {
        super(System.out);
    }

    @Override
    public void close() {}

}

