package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Function<String, Person> parsePerson = str -> {
            String[] tokens = str.split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        };
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            people.add(parsePerson.apply(scanner.nextLine()));
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = condition.equals("older")
                ? filterPeople(people, p -> p.age >= ageCondition)
                : filterPeople(people, p -> p.age <= ageCondition);
        System.out.println(formatPeople(people,
                getFormatterFunction(format), System.lineSeparator()));
    }

    private static Function<Person, String> getFormatterFunction(String format) {
        switch (format) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case "name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException("Unknown format type " + format);
        }
    }

    public static String formatPeople(Collection<Person> people,
                                      Function<Person, String> formatter,
                                      String delimiter) {
        return people.stream().map(p -> formatter.apply(p))
                .collect(Collectors.joining(delimiter));
    }

    public static List<Person> filterPeople(Collection<Person> people,
                                            Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
