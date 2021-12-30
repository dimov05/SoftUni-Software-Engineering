package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = dimensions[0];

        int[][] matrix = new int[matrixRows][];

        for (int i = 0; i < matrixRows; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = array;
        }
        int number = scanner.nextInt();
        if (isContaining(number, matrix)) {
            printPositions(number, matrix);
        } else {
            System.out.println("not found");
        }
    }

    private static void printPositions(int number, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    System.out.printf("%d %d%n",
                            row, col);
                }
            }
        }
    }

    private static boolean isContaining(int number, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
