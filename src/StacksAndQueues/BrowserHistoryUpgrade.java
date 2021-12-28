package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stackUrls = new ArrayDeque<>();
        ArrayDeque<String> forwardsQueue = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                break;
            }

            if (input.equals("back")) {
                if (stackUrls.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardsQueue.push(stackUrls.pop());
                    System.out.println(stackUrls.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardsQueue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    stackUrls.push(forwardsQueue.peekFirst());
                    System.out.println(forwardsQueue.pop());
                }
            } else {
                stackUrls.push(input);
                System.out.println(input);
                forwardsQueue.clear();
            }
        }
    }
}
