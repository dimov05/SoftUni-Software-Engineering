package ExerciseMultidimensionalArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().replace(")", "").split("\\(");
        int rotateDegrees = Integer.parseInt(command[1]) % 360;
        List<String> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            list.add(input);
        }


        int longestWord = getLongestWord(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < longestWord) {
                int count = longestWord - list.get(i).length();
                StringBuilder word = new StringBuilder(list.get(i));
                word.append(" ".repeat(Math.max(0, count)));
                list.set(i, word.toString());
            }
        }
        if (rotateDegrees == 0) {
            printList(list);
        } else if (rotateDegrees == 90) {
            Collections.reverse(list);
            char[][] matrix = rotate90Matrix(list, longestWord);
            printMatrix(matrix);
        } else if (rotateDegrees == 180) {
            char[][] matrix = rotate180Matrix(list, longestWord);
            printMatrix(matrix);
        } else if (rotateDegrees == 270) {
            char[][] matrix = rotate270Matrix(list, longestWord);
            printMatrix(matrix);
        }

    }


    private static char[][] rotate180Matrix(List<String> list, int longestWord) {
        char[][] matrix = new char[list.size()][longestWord];
        int listCounter = 0;

        for (int row = list.size() - 1; row >= 0; row--, listCounter++) {
            int charCounter = 0;
            for (int col = longestWord - 1; col >= 0; col--, charCounter++) {
                matrix[row][col] = list.get(listCounter).charAt(charCounter);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.printf("%s", element);
            }
            System.out.println();
        }
    }

    private static char[][] rotate270Matrix(List<String> list, int longestWord) {
        char[][] matrix = new char[longestWord][list.size()];
        int num = 0;
        for (int row = longestWord - 1; row >= 0; row--, num++) {
            for (int col = 0; col < list.size(); col++) {
                matrix[row][col] = list.get(col).charAt(num);
            }
        }
        return matrix;
    }

    private static char[][] rotate90Matrix(List<String> list, int longestWord) {
        char[][] matrix = new char[longestWord][list.size()];
        for (int row = 0; row < longestWord; row++) {
            for (int col = 0; col < list.size(); col++) {
                matrix[row][col] = list.get(col).charAt(row);
            }
        }
        return matrix;
    }

    private static int getLongestWord(List<String> list) {
        int max = Integer.MIN_VALUE;
        for (String word : list) {
            if (word.length() > max) {
                max = word.length();

            }
        }
        return max;
    }

    private static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
