package ExerciseStacksandQueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        long[] memo = new long[number + 1];
        System.out.println(recursiveFibonacciWithMemo(number, memo));
    }

    public static long recursiveFibonacciWithMemo(int n, long[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = recursiveFibonacciWithMemo(n - 1, memo)
                + recursiveFibonacciWithMemo(n - 2, memo);
        return memo[n];
    }
}
