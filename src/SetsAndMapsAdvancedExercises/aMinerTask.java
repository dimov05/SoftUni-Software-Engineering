package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        while (true) {
            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(resource)) {
                resources.put(resource, resources.get(resource) + quantity);
            } else {
                resources.put(resource, quantity);
            }
        }
        resources.forEach((mat, quantity) -> System.out.printf("%s -> %d%n",
                mat, quantity));
    }
}
