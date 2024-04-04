package exporter;

import java.io.IOException;
import java.io.OutputStream;

class StreamTextExporter implements TextExporter {
    private final OutputStream outputStream;
    private boolean closed = false;

    public StreamTextExporter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    protected void exportToStream(String item) throws IOException {
        if (closed)
            throw new IOException("The stream is already closed");

        outputStream.write(item.getBytes("UTF-8"));
        outputStream.flush();
    }

    public void close() throws IOException {
        if (closed)
            return;

        outputStream.close();
        closed = true;
    }

    @Override
    public void display(String item) throws IOException {
        exportToStream(item);
    }
}
