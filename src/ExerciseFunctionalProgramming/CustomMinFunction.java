package ExerciseFunctionalProgramming;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        Function<Set<Integer>, Integer> min = numbers -> {
            int minimum = Integer.MAX_VALUE;
            for (int n : set) {
                if (n < minimum) {
                    minimum = n;
                }
            }
            return minimum;
        };
        System.out.println(min.apply(set));

    }
}
