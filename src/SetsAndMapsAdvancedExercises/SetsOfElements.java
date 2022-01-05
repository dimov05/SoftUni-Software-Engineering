package SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = getArray(scanner);
        int a = input[0];
        int b = input[1];
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < a; i++) {
            first.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < b; i++) {
            second.add(Integer.parseInt(scanner.nextLine()));
        }
        first.forEach(e -> {
            if (second.contains(e)) {
                System.out.printf("%d ", e);
            }
        });


    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
