package GenericsExercises.GenericsBox.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    private static void isEmpty(boolean empty) {
        if (empty) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T value : this.values){
            sb.append(value).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public T getMin() {
        isEmpty(this.values.isEmpty());
        return Collections.min(this.values);
    }

    public T getMax() {
        isEmpty(this.values.isEmpty());
        return Collections.max(this.values);
    }

    public void add(T value) {
        this.values.add(value);
    }

    public void remove(int index) {
        this.values.remove(index);
    }

    public boolean contains(T value) {
        return this.values.contains(value);
    }

    public void swap(int indexFirst, int indexSecond) {
        T first = this.values.get(indexFirst);
        this.values.set(indexFirst, this.values.get(indexSecond));
        this.values.set(indexSecond, first);
    }

    public long countGreaterThan(T toCompare) {
        return this.values.stream()
                .filter(e -> e.compareTo(toCompare) > 0).count();
    }

    public int getSize() {
        return this.values.size();
    }

    public T get(int i) {
        return this.values.get(i);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < values.size();
            }

            @Override
            public T next() {
                T element = values.get(index);
                index++;
                return element;
            }
        };
    }
}


