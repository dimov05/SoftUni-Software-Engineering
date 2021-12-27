package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("print")) {
                break;
            }

            if (input.equals("cancel")) {
                String fileName = queue.poll();

                if (fileName != null) {
                    System.out.println("Canceled " + fileName);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(input);
            }
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
