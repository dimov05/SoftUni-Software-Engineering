package ExerciseFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Consumer<List<String>> printer = listOfNames -> listOfNames
                .forEach(p -> System.out.println("Sir " + p));
        printer.accept(input);
    }
}
