package ExerciseFunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    static List<String> names = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line;
        while (!"Party!".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Double":
                    addOneMore(getPredicate(tokens));
                    break;
                case "Remove":
                    removeOne(getPredicate(tokens));
                    break;
            }
        }
        Collections.sort(names);

        Consumer<List<String>> printNames = list -> {
            if (names.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                System.out.println(String.join(", ",names) + " are going to the party!");
            }
        };
        printNames.accept(names);
    }

    public static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    public static void removeOne(Predicate<String> predicate) {
        List<String> namesToRemove = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToRemove::add);
        names.removeAll(namesToRemove);
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate;

        if (tokens[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }
        return predicate;
    }
}
