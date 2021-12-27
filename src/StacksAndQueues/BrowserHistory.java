package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String lastUrl = null;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                break;
            }
            if (input.equals("back")) {
                if (history.isEmpty()) {
                    lastUrl = "no previous URLs";
                } else {
                    lastUrl = history.pop();
                }
            } else {
                if (lastUrl != null) {
                    history.push(lastUrl);
                }
                lastUrl = input;
            }
            System.out.println(lastUrl);
        }
    }
}
