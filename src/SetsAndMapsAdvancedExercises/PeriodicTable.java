package SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(input));
        }

        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
