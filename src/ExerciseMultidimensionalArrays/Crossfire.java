package ExerciseMultidimensionalArrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] command = getArray(scanner);
        int rows = command[0];
        int cols = command[1];
        int currentNumber = 1;
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.valueOf(currentNumber);
                currentNumber++;
            }
        }
        String commandLine;
        while (!"Nuke it from orbit".equals(commandLine = scanner.nextLine())) {

            int[] tokens = Arrays.stream(commandLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];


            destroyCol(matrix, row, col, radius);
            destroyRow(matrix, row, col, radius);
            matrix = clearEmptyCells(matrix);

        }
        printMatrix(matrix);
    }

    private static void destroyRow(String[][] matrix, int row, int col, int radius) {
        for (int i = col - radius; i <= col + radius; i++) {
            if (isInTheMatrix(row, i, matrix)) {
                matrix[row][i] = null;
            }
        }
    }

    private static boolean isInTheMatrix(int currentRow, int currentCol, String[][] matrix) {
        return currentRow >= 0 && currentRow < matrix.length
                && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }

    private static void destroyCol(String[][] matrix, int row, int col, int radius) {
        for (int i = row - radius; i <= row + radius; i++) {
            if (isInTheMatrix(i, col, matrix)) {
                matrix[i][col] = null;
            }
        }
    }

    private static String[][] clearEmptyCells(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i])
                    .filter(Objects::nonNull)
                    .toArray(String[]::new);
        }
        matrix = Arrays.stream(matrix)
                .filter(l -> l.length > 0).toArray(String[][]::new);
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            StringBuilder sb = new StringBuilder();
            for (String element : rows) {
                sb.append(element).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
