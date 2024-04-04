package exporter;

import java.io.IOException;
public interface Exporter<T> {

    void display(T image) throws IOException;;
}
