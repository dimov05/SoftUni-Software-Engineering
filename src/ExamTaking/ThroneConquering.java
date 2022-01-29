package ExamTaking;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[rows][];
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            char[] chArray = new char[input.length()];
            fillCharArray(input, chArray);
            field[i] = chArray;
        }
        int parisRow = 0;
        int parisCol = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        while (energy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            int spawnRow = Integer.parseInt(tokens[1]);
            int spawnCol = Integer.parseInt(tokens[2]);
            field[spawnRow][spawnCol] = 'S';

            if (direction.equals("up")) {
                if (checkPosition(parisRow - 1, parisCol, field)) {
                    field[parisRow][parisCol] = '-';
                    energy--;
                    parisRow--;
                } else {
                    energy--;
                }
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n",
                                parisRow, parisCol);
                        break;
                    }
                } else if (field[parisRow][parisCol] == 'H') {
                    field[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",
                            energy);
                    break;
                } else {
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n",
                                parisRow, parisCol);
                        break;
                    }
                }
            } else if (direction.equals("down")) {
                if (checkPosition(parisRow + 1, parisCol, field)) {
                    field[parisRow][parisCol] = '-';
                    energy--;
                    parisRow++;
                } else {
                    energy--;
                }
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n",
                                parisRow, parisCol);
                        break;
                    }

                } else if (field[parisRow][parisCol] == 'H') {
                    field[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",
                            energy);
                    break;
                } else {
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        break;
                    }
                }
            } else if (direction.equals("left")) {
                if (checkPosition(parisRow, parisCol - 1, field)) {
                    field[parisRow][parisCol] = '-';
                    energy--;
                    parisCol--;
                } else {
                    energy--;
                }
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n",
                                parisRow, parisCol);
                        break;
                    }
                } else if (field[parisRow][parisCol] == 'H') {
                    field[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",
                            energy);
                    break;
                } else {
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        break;
                    }
                }
            } else if (direction.equals("right")) {
                if (checkPosition(parisRow, parisCol + 1, field)) {
                    field[parisRow][parisCol] = '-';
                    energy--;
                    parisCol++;
                } else {
                    energy--;
                }
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n",
                                parisRow, parisCol);
                        break;
                    }
                } else if (field[parisRow][parisCol] == 'H') {
                    field[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",
                            energy);
                    break;
                } else {
                    if (energy > 0) {
                        field[parisRow][parisCol] = 'P';
                    } else {
                        field[parisRow][parisCol] = 'X';
                        break;
                    }
                }
            }
        }

        printField(field);
    }

    private static boolean checkPosition(int parisRow, int parisCol, char[][] field) {
        if (parisRow >= 0 && parisRow < field.length) {
            return parisCol >= 0 && parisCol < field[parisRow].length;
        }
        return false;
    }

    private static void printField(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void fillCharArray(String input, char[] chArray) {
        for (int c = 0; c < input.length(); c++) {
            chArray[c] = input.charAt(c);
        }
    }
}

