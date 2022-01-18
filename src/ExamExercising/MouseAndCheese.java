package ExamExercising;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int rowCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int mouseRow = 0;
        int mouseCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int m = 0; m < matrix[i].length; m++) {
                if (matrix[i][m] == 'M') {
                    mouseRow = i;
                    mouseCol = m;
                }
            }
        }
        int cheeseCounter = 0;
        boolean isInMatrix = true;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            matrix[mouseRow][mouseCol] = '-';
            switch (input) {
                case "up":
                    mouseRow--;
                    if (isValidRow(mouseRow, matrix)) {
                        if (isCheese(matrix[mouseRow][mouseCol])) {
                            cheeseCounter++;
                        } else if (isBonus(matrix[mouseRow][mouseCol])) {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseRow--;
                            if (isCheese(matrix[mouseRow][mouseCol])) {
                                cheeseCounter++;
                            }
                        }
                    } else {
                        isInMatrix = false;
                        break;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
                case "down":
                    mouseRow++;
                    if (isValidRow(mouseRow, matrix)) {
                        if (isCheese(matrix[mouseRow][mouseCol])) {
                            cheeseCounter++;
                        } else if (isBonus(matrix[mouseRow][mouseCol])) {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseRow++;
                            if (isCheese(matrix[mouseRow][mouseCol])) {
                                cheeseCounter++;
                            }
                        }
                    } else {
                        isInMatrix = false;
                        break;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
                case "left":
                    mouseCol--;
                    if (isValidCol(mouseCol, mouseRow, matrix)) {
                        if (isCheese(matrix[mouseRow][mouseCol])) {
                            cheeseCounter++;
                        } else if (isBonus(matrix[mouseRow][mouseCol])) {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseCol--;
                            if (isCheese(matrix[mouseRow][mouseCol])) {
                                cheeseCounter++;
                            }
                        }
                    } else {
                        isInMatrix = false;
                        break;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
                case "right":
                    mouseCol++;
                    if (isValidCol(mouseCol, mouseRow, matrix)) {
                        if (isCheese(matrix[mouseRow][mouseCol])) {
                            cheeseCounter++;
                        } else if (isBonus(matrix[mouseRow][mouseCol])) {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseCol++;
                            if (isCheese(matrix[mouseRow][mouseCol])) {
                                cheeseCounter++;
                            }
                        }
                    } else {
                        isInMatrix = false;
                        break;
                    }
                    matrix[mouseRow][mouseCol] = 'M';
                    break;
            }
            if (!isInMatrix) {
                break;
            }
        }

        if (!isInMatrix) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseCounter >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",
                    cheeseCounter);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",
                    5 - cheeseCounter);
        }
        printMatrix(matrix);
    }

    private static boolean isBonus(char matrix2) {
        return matrix2 == 'B';
    }

    private static boolean isCheese(char matrix2) {
        return matrix2 == 'c';
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static boolean isValidCol(int mouseCol, int mouseRow, char[][] matrix) {
        return 0 <= mouseCol && mouseCol < matrix[mouseRow].length;
    }

    private static boolean isValidRow(int mouseRow, char[][] matrix) {
        return 0 <= mouseRow && mouseRow < matrix.length;
    }

}
