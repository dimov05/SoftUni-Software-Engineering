package ExerciseMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = getArray(scanner);
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] array = getArray(scanner);
            matrix[row] = array;
        }
        int[][] maxMatrix = getMaxMatrix(matrix);
        int maxSum = getMaxSum(maxMatrix);
        System.out.printf("Sum = %d%n", maxSum);
        printMaxMatrix(maxMatrix);

    }

    private static void printMaxMatrix(int[][] maxMatrix) {
        for (int[] rows : maxMatrix) {
            for (int element : rows) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
    }

    private static int getMaxSum(int[][] maxMatrix) {
        int sum = 0;
        for (int[] matrix : maxMatrix) {
            for (int number : matrix) {
                sum += number;
            }
        }
        return sum;
    }

    private static int[][] getMaxMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int rowStart = 0, column = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowStart = row;
                    column = col;

                }
            }
        }
        return new int[][]{
                {matrix[rowStart][column], matrix[rowStart][column + 1], matrix[rowStart][column + 2]},
                {matrix[rowStart + 1][column], matrix[rowStart + 1][column + 1], matrix[rowStart + 1][column + 2]},
                {matrix[rowStart + 2][column], matrix[rowStart + 2][column + 1], matrix[rowStart + 2][column + 2]}
        };
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
