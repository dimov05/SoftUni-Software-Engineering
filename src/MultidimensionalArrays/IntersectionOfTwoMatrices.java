package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixCols = Integer.parseInt(scanner.nextLine());

        //First Matrix
        String[][] firstMatrix = new String[matrixRows][];

        for (int i = 0; i < matrixRows; i++) {
            String[] array = scanner.nextLine().split(" ");


            firstMatrix[i] = array;
        }

        //Second Matrix
        String[][] secondMatrix = new String[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            String[] array = scanner.nextLine().split(" ");
            secondMatrix[i] = array;
        }
        String[][] resultMatrix = new String[matrixRows][matrixCols];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = "*";
                }
            }
        }
        printResult(resultMatrix);
    }

    private static void printResult(String[][] resultMatrix) {
        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
