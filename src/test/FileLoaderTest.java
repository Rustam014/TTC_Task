package test;

import loader.FileLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileLoaderTest {
    @Test
    public void testLoad_FileExists() throws Exception {
        String filePath = "testFile.txt";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Integer num : expected) {
                writer.write(num + "\n");
            }
        }

        FileLoader loader = new FileLoader();

        List<Integer> loadedNumbers = loader.load(filePath);

        Assertions.assertEquals(expected, loadedNumbers);

        File file = new File(filePath);
        file.delete();
    }

    @Test
    public void testLoad_FileDoesNotExist() {
        String filePath = "nonexistentFile.txt";

        FileLoader loader = new FileLoader();

        assertThrows(Exception.class, () -> {
            loader.load(filePath);
        }, "Error: File doesn't exist");
    }
}
