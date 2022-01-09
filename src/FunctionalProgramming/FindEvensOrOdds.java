package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = getRangeArray(scanner);
        int start = range[0];
        int end = range[1];
        String condition = scanner.nextLine();
        int numType;
        numType = getNumType(condition);
        List<Integer> numbers = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        List<Integer> filteredList = filtered(numbers, n -> n % 2 == numType || n % 2 == -1);
        filteredList.forEach(n -> System.out.printf("%d ", n));
    }

    private static int[] getRangeArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int getNumType(String condition) {
        int numType;
        if (condition.equals("odd")) {
            numType = 1;
        } else {
            numType = 0;
        }
        return numType;
    }

    public static List<Integer> filtered(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> last = new ArrayList<>();
        list.forEach(num -> {
            if (predicate.test(num)) {
                last.add(num);
            }
        });
        return last;
    }
}
