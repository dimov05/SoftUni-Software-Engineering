package hotel;

public  class Person {
    String name;
    int id;
    int age;
    String hometown = "n/a";

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s",
                this.name, this.id, this.age, this.hometown);
    }
}
