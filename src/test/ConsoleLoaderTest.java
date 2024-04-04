package test;

import loader.ConsoleLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class ConsoleLoaderTest {
    @Test
    public void testLoad() {
        String input = "1 2 3 4 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ConsoleLoader loader = new ConsoleLoader();

        List<Integer> loadedNumbers = loader.load("input.txt");

        Assertions.assertEquals(5, loadedNumbers.size());
        Assertions.assertEquals(1, loadedNumbers.get(0).intValue());
        Assertions.assertEquals(2, loadedNumbers.get(1).intValue());
        Assertions.assertEquals(3, loadedNumbers.get(2).intValue());
        Assertions.assertEquals(4, loadedNumbers.get(3).intValue());
        Assertions.assertEquals(5, loadedNumbers.get(4).intValue());
    }
}
