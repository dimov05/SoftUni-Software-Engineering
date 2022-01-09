package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(SortEvenNumbers::isEven)
                .toArray();

        if (isEmpty(numbers)) {
            System.out.println("(no output)");
        } else {
            System.out.println(formatArray(numbers));
            Arrays.sort(numbers);
            System.out.println(formatArray(numbers));
        }
    }

    private static boolean isEmpty(int[] numbers) {
        return numbers.length <= 0;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static String formatArray(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
