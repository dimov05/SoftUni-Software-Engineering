package FunctionalProgramming;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> startsWithUpperCase = str -> str != null
                && !str.isEmpty() && Character.isUpperCase(str.charAt(0));
        List<String> upperCaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords.size());
        System.out.println(upperCaseWords.stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
