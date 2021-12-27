package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, children);

        int tossCount = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < tossCount; i++) {
                if (!queue.isEmpty()) {
                    queue.offer(queue.poll());
                }
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.printf("Last is %s",
                queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        } else {
            for (int i = 2; i < cycle; i++) {
                if (cycle % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
