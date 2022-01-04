package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();
        double[] input = getArray(scanner);

        for (double v : input) {
            if (!numbers.containsKey(v)) {
                numbers.put(v, 1);
            } else {
                numbers.put(v, numbers.get(v) + 1);
            }
        }

        for (Map.Entry<Double, Integer> num : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n",
                    num.getKey(), num.getValue());
        }

    }

    private static double[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" ")).mapToDouble(Double::parseDouble).toArray();
    }
}
