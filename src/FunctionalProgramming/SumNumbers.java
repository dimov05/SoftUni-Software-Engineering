package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = getInput(scanner);

        Function<String, IntStream> getIntStream = str -> Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt);

        Function<String, Long> getCount = str -> getIntStream.apply(str).count();

        Function<String, Integer> getSum = str -> getIntStream.apply(str).sum();

        System.out.println("Count = " + getCount.apply(input));
        System.out.println("Sum = " + getSum.apply(input));
    }

    private static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
