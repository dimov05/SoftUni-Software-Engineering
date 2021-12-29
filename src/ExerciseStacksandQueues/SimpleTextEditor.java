package ExerciseStacksandQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        String start = "";
        queue.offer(start);

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            int cmd = Integer.parseInt(command[0]);
            switch (cmd) {
                case 1:
                    queue.offer(queue.peekLast() + command[1]);
                    break;
                case 2:
                    int count = Integer.parseInt(command[1]);
                    String q = queue.peekLast();
                    String add = "";
                    if (q != null && q.length() > count) {
                        add = q.substring(0, q.length() - count);
                    }
                    queue.offer(add);
                    break;
                case 3:
                    int index = Integer.parseInt(command[1]);
                    String print = queue.peekLast();
                    if (print != null) {
                        System.out.println(print.charAt(index - 1));
                    }
                    break;
                case 4:
                    queue.pollLast();
                    break;
            }
        }
    }
}
