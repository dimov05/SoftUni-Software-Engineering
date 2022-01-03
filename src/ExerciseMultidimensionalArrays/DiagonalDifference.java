package ExerciseMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            int[] array = getColumns(scanner);
            matrix[row] = array;
        }
        int sumFirstDiagonal = getFirstDiagonalSum(matrix);
        int sumSecondDiagonal = getSecondDiagonalSum(matrix);
        System.out.printf("%d",
                Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }

    private static int getSecondDiagonalSum(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--, col++) {
            sum += matrix[row][col];
        }
        return sum;
    }

    private static int getFirstDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int[] getColumns(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
