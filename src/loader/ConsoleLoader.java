package loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleLoader implements NumberLoader {
    @Override
    public List<Integer> load(String path) {
        List<Integer> result = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by space (to finish, enter a non-numeric value): ");

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            result.add(num);
        }
        scanner.close();

        return result;
    }
}
