package ExerciseIteratorsAndComparators.ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine()
                .split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);
        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            switch (input) {
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "Print":
                    try {
                        listyIterator.Print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        listyIterator.printALl();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }

}
