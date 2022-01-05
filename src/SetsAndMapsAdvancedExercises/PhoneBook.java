package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split("-");
            if (input[0].equals("search")) {
                break;
            }
            phoneBook.put(input[0], input[1]);
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            if (phoneBook.containsKey(input)) {
                System.out.printf("%s -> %s%n",
                        input, phoneBook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n",
                        input);
            }
        }
    }
}
