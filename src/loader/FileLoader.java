package loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader implements NumberLoader{
    @Override
    public List<Integer> load(String path) throws Exception {
        List<Integer> result = new ArrayList<>();

        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                result.add(scanner.nextInt());
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new Exception("Error: File doesn't exist: ", e);
        }
        return result;
    }
}
