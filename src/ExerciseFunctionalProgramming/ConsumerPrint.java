package ExerciseFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Consumer<List<String>> printer = word -> word
                .forEach(System.out::println);
        printer.accept(input);
    }
}
