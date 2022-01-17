package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    String name;
    int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person guest : this.roster) {
            if (name.equals(guest.name)) {
                this.roster.remove(guest);
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return this.roster.size();
    }

    public Person getPerson(String name, String hometown) {
        for (Person guest : this.roster) {
            if (guest.name.equals(name) && guest.hometown.equals(hometown)) {
                return guest;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:", this.name))
                .append(System.lineSeparator());
        for (Person guest : roster) {
            sb.append(guest).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
