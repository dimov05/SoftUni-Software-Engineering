package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, children);

        int tossCount = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1) {
            for (int i = 1; i < tossCount; i++) {
                if (!queue.isEmpty()) {
                    queue.offer(queue.poll());
                }
            }
            System.out.printf("Removed %s%n",
                    queue.poll());

        }
        System.out.printf("Last is %s",
                queue.poll());
    }
}
