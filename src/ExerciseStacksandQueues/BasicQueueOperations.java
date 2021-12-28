package ExerciseStacksandQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        int push = Integer.parseInt(input[0]);
        int pop = Integer.parseInt(input[1]);
        int check = Integer.parseInt(input[2]);

        for (int i = 0; i < push; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 0; i < pop; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(check)) {
                System.out.println("true");
            } else {
                int min = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    if (min > queue.peek()) {
                        min = queue.peek();
                    }
                    queue.poll();
                }
                System.out.println(min);
            }
        }
    }
}
