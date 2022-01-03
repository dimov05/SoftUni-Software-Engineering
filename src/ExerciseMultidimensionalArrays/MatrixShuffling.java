package ExerciseMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.input
        int[] size = getArray(scanner);
        int rowCount = size[0];
        int colCount = size[1];
        int[][] matrix = new int[rowCount][colCount];
        for (int row = 0; row < rowCount; row++) {
            int[] array = getArray(scanner);
            matrix[row] = array;
        }
        //2.switch case
        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("END")) {
                break;
            }
            if (isInvalid2(command)) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int row2 = Integer.parseInt(command[3]);
            int col2 = Integer.parseInt(command[4]);

            if (isInvalid(rowCount, colCount, row1, col1, row2, col2)) {
                System.out.println("Invalid input!");
                continue;
            }
            int firstToSwap = matrix[row1][col1];
            int secondToSwap = matrix[row2][col2];
            matrix[row1][col1] = secondToSwap;
            matrix[row2][col2] = firstToSwap;

            printMatrix(matrix);
        }
    }

    private static boolean isInvalid2(String[] command) {
        return !command[0].equals("swap") || command.length != 5;
    }

    private static boolean isInvalid(int rowCount, int colCount, int row1, int col1, int row2, int col2) {
        return row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0
                || row1 >= rowCount || row2 >= rowCount
                || col1 >= colCount || col2 >= colCount;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int element : rows) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
