package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emailBook = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = scanner.nextLine();
            emailBook.put(name, email);
        }

        emailBook.forEach((name, email) -> {
            String[] emailEnd = email.split("\\.");
            String emailEnding = emailEnd[emailEnd.length - 1];
            if (!emailEnding.equals("us")
                    && !emailEnding.equals("uk")
                    && !emailEnding.equals("com")) {
                System.out.printf("%s -> %s%n",
                        name, email);
            }
        });
    }
}