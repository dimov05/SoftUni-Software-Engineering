package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (number != 0) {
            while (number > 0) {
                int current = number % 2;
                binaryNumber.push(current);
                number /= 2;
            }
        } else {
            System.out.println(0);
        }

        while (!binaryNumber.isEmpty()) {
            System.out.print(binaryNumber.pop());
        }
    }
}
