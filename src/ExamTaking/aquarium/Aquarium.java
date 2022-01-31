package aquarium;

import java.util.LinkedHashSet;
import java.util.Set;

public class Aquarium {
    public Set<Fish> fishInPool;
    public String name;
    public int capacity;
    public int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public boolean remove(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                this.fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public void add(Fish fish) {
        if (!this.fishInPool.contains(fish) && getFishInPool() < getCapacity()) {
            this.fishInPool.add(fish);
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public StringBuilder report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ").append(getName())
                .append(" ^ Size: ")
                .append(getSize())
                .append(System.lineSeparator());
        for (Fish fish : this.fishInPool) {
            sb.append(fish);
        }
        return sb;

    }
}
