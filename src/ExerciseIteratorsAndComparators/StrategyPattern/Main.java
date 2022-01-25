package ExerciseIteratorsAndComparators.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleByAge.add(person);
            peopleByName.add(person);
        }

        for (Person person : peopleByName) {
            System.out.println(person);
        }
        for (Person person : peopleByAge) {
            System.out.println(person);
        }
    }
}
