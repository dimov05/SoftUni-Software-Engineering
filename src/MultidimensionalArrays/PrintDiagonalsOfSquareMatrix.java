package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] array = getColumns(scanner);
            matrix[row] = array;
        }
        int[][] diagonals = new int[2][];

        int[] firstDiagonal = new int[rows];
        for (int row = 0; row < matrix.length; row++) {
            firstDiagonal[row] = matrix[row][row];
        }

        int[] secondDiagonal = new int[rows];
        int m = 0;
        int column = 0;
        for (int row = matrix.length - 1; row >= 0; row--, m++) {
            secondDiagonal[m] = matrix[row][column];
            column++;
        }
        diagonals[0] = firstDiagonal;
        diagonals[1] = secondDiagonal;
        printDiagonals(diagonals);

    }

    private static void printDiagonals(int[][] diagonals) {
        for (int row = 0; row < diagonals.length; row++) {
            for (int col = 0; col < diagonals[row].length; col++) {
                System.out.print(diagonals[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getColumns(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
