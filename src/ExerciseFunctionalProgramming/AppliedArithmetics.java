package ExerciseFunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        boolean breakLoop = false;
        Function<int[], int[]> addOne = arr -> Arrays.stream(arr)
                .map(num -> num + 1).toArray();
        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr)
                .map(num -> num - 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr)
                .map(num -> num * 2).toArray();

        while (!breakLoop) {
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
                    System.out.println();
                    break;
                case "end":
                    breakLoop = true;
                    break;
            }
        }

    }
}
