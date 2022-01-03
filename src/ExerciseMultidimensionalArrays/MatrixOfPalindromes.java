package ExerciseMultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = fillMatrix(rows, cols);

        printMatrix(matrix);
    }

    private static String[][] fillMatrix(int rows, int cols) {
        char border = 'a';
        char middle = 'a';
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                StringBuilder output = new StringBuilder();
                char m = (char) (border + row);
                char p = (char) (middle + col + row);
                output.append(m);
                output.append(p);
                output.append(m);
                matrix[row][col] = output.toString();
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String element : rows) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
    }
}
