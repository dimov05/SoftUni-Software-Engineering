package ExerciseStacksandQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int cmd = Integer.parseInt(input[0]);

            switch (cmd) {
                case 1:
                    int element = Integer.parseInt(input[1]);
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Object[] max = stack.toArray();
                    Arrays.sort(max);
                    System.out.println(max[max.length - 1]);
                    break;
            }
        }
    }
}
