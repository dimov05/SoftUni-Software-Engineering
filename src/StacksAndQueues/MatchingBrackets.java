package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> chars = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '(') {
                chars.push(i);
            } else if (input.charAt(i) == ')') {
                int startIndex = chars.pop();
                String contents = input.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
