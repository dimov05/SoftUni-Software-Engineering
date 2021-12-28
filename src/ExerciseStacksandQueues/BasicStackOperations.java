package ExerciseStacksandQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int push = Integer.parseInt(input[0]);
        int pop = Integer.parseInt(input[1]);
        int print = Integer.parseInt(input[2]);

        for (int i = 0; i < push; i++) {
            numbers.push(scanner.nextInt());
        }

        for (int i = 0; i < pop; i++) {
            numbers.pop();
        }

        if (numbers.contains(print)) {
            System.out.println("true");
        } else {
            int min = Integer.MAX_VALUE;

            if (numbers.isEmpty()) {
                System.out.println(0);
            } else {
                while (!numbers.isEmpty()) {
                    if (min > numbers.peek()) {
                        min = numbers.peek();
                    }
                    numbers.pop();
                }
                System.out.println(min);
            }
        }
    }
}
