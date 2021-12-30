package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = getDimensions(scanner);
        int matrixRows = dimensions[0];

        int[][] matrix = new int[matrixRows][];

        for (int i = 0; i < matrixRows; i++) {
            int[] array = getDimensions(scanner);
            matrix[i] = array;
        }
        int sum = 0;
        int[][] maxMatrix = new int[2][2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = getCurrentSum(matrix, row, col);
                if (currentSum > sum) {
                    sum = currentSum;
                    maxMatrix = new int[][]{
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(sum);


    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCurrentSum(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1]
                + matrix[row + 1][col] + matrix[row + 1][col + 1];
    }

    private static int[] getDimensions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
