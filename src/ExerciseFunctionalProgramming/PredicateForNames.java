package ExerciseFunctionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> checker = str -> str.length() <= length;

        List<String> names = List.of(scanner.nextLine().split("\\s+"));
        names.stream().filter(checker)
                .forEach(System.out::println);
    }
}
