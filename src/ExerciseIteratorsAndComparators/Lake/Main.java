package ExerciseIteratorsAndComparators.Lake;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(input);
        Iterator<Integer> froggy = lake.iterator();

        String output = scanner.nextLine();
        List<String> result = new ArrayList<>();
        while (froggy.hasNext()) {
            result.add(froggy.next() + "");
        }
        System.out.println(String.join(", ", result));

    }
}
