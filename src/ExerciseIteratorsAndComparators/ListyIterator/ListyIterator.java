package ExerciseIteratorsAndComparators.ListyIterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    static int a;
    private List<String> list;
    private int index;


    public ListyIterator(List<String> data) {
        this.list = data;
    }

    public void Print() {
        validatePrint();
        System.out.println(this.list.get(this.index));
    }

    public void printALl() {
        validatePrint();
        this.list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private void validatePrint() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    public boolean Move() {
        if (iterator().hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean HasNext() {
        return index < list.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < list.size() - 1;
            }

            @Override
            public String next() {
                String element = list.get(index);
                index++;
                return element;
            }
        };
    }
}
