import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMax(List<T> elements) {
        isEmpty(elements.isEmpty());
        return Collections.max(elements);
    }

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        isEmpty(elements.isEmpty());
        return Collections.min(elements);
    }

    private static void isEmpty(boolean empty) {
        if (empty) {
            throw new IllegalArgumentException();
        }
    }
}
