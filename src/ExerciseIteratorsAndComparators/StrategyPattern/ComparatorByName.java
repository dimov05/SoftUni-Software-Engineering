package ExerciseIteratorsAndComparators.StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int res = p1.getName().length() - p2.getName().length();

        if (res == 0) {
            char p1FirstLetter = p1.getName().toLowerCase(Locale.ROOT).charAt(0);
            char p2FirstLetter = p2.getName().toLowerCase(Locale.ROOT).charAt(0);
            res = p1FirstLetter - p2FirstLetter;
        }

        return res;
    }
}
