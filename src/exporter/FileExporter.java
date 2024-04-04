package exporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExporter extends StreamTextExporter {
    public FileExporter(File file) throws IOException {
        super(new FileOutputStream(file));
    }
}