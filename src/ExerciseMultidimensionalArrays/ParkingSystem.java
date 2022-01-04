package ExerciseMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rowSize = dimensions[0];
        int colSize = dimensions[1];
        boolean[][] matrix = new boolean[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
                matrix[row][0] = true;
        }

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            int[] input = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int entry = input[0];
            int row = input[1];
            int col = input[2];
            int distance = Math.abs(entry - row) + 1;
            int tempColLeft = 0 >= col - 1 ? 1 : col - 1;
            int tempColRight = col + 1 >= matrix[0].length - 1 ? col : col + 1;

            while (matrix[row][tempColLeft]) {
                if (tempColLeft == 0) {
                    break;
                }
                tempColLeft--;
            }
            while (matrix[row][tempColRight]) {
                if (tempColRight == matrix[0].length - 1) {
                    break;
                }
                tempColRight++;
            }
            if (isRowFull(matrix, row)) {
                System.out.printf("Row %d full%n", row);
                continue;
            }
            if (!matrix[row][col]) {
                matrix[row][col] = true;
                distance += col;
                System.out.println(distance);
                continue;
            } else {
                if ((col - tempColLeft) > (Math.abs(tempColRight - col))) {
                    col = tempColRight;
                } else {
                    col = tempColLeft;
                }
            }
            if (col <= 1 && matrix[row][col]) {
                col = tempColRight;
            }
            if (matrix[row][col] && tempColRight == matrix[0].length - 1) {
                col = tempColLeft;
            }
            matrix[row][col] = true;
            distance += col;
            System.out.println(distance);
        }
    }

    private static boolean isRowFull(boolean[][] matrix, int row) {
        for (int col = 1; col < matrix[0].length; col++) {
            if (!matrix[row][col]) {
                return false;
            }
        }
        return true;
    }
}
