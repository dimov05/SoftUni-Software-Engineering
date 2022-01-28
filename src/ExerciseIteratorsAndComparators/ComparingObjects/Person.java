package ExerciseIteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        setAge(age);
        this.town = town;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("You can not create person with negative age.");
        }
    }

    @Override
    public int compareTo(Person secondPerson) {
        int res = this.name.compareTo(secondPerson.name);
        if (res == 0) {
            res = Integer.compare(this.age, secondPerson.age);
            if (res == 0) {
                res = this.town.compareTo(secondPerson.town);
            }
        }
        return res;
    }
}
