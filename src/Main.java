import exporter.ConsoleExporter;
import exporter.FileExporter;
import exporter.TextExporter;
import loader.ConsoleLoader;
import loader.FileLoader;
import loader.NumberLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Error: No data source specified.");
            return;
        }

        String inputSource = args[0];
        boolean writeToConsole = args.length == 1;
        NumberLoader loader = inputSource.matches("\\d+") ? new ConsoleLoader() : new FileLoader();
        TextExporter exporter = writeToConsole ? new ConsoleExporter() : new FileExporter(new File(args[1]));

        List<Integer> numbers = loader.load(inputSource);
        List<Integer> result = processNumbers(numbers);
        exporter.display(result.toString());
    }

    private static List<Integer> processNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        if (numbers.size() % 2 == 0) {
            for (Integer var : numbers) {
                if (var % 2 == 0) result.add(var);
            }
        } else {
            for (Integer var : numbers) {
                if (var % 2 != 0) result.add(var);
            }
        }
        return result;
    }
}