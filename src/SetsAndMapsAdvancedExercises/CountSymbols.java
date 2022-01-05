package SetsAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> chars = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (chars.containsKey(ch)) {
                chars.put(ch, chars.get(ch) + 1);
            } else {
                chars.put(ch, 1);
            }
        }
        chars.forEach((ch, count) -> System.out.printf("%c: %d time/s%n", ch, count));
    }
}
