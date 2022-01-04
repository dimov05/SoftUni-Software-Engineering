package SetsAndMapsAdvanced;



import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("PARTY")) {
                break;
            }
            guests.add(input);
        }

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }
            if (guests.contains(input)) {
                guests.remove(input);
            }
        }
        System.out.println(guests.size());

        for (String element : guests) {
            if (Character.isDigit(element.charAt(0))) {
                System.out.println(element);
            }
        }

        for (String element : guests) {
            if (Character.isLetter(element.charAt(0)))
                System.out.println(element);
        }
    }
}
