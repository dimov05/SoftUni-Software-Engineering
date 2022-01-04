package ExerciseMultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hpHeigan = 3000000;
        double hpPlayer = 18500;
        double attackPower = Double.parseDouble(scanner.nextLine());
        int startPlRow = 7;
        int startPlCol = 7;
        String lastSpell = "";
        boolean activeCloud = false;

        while (hpPlayer > 0 && hpHeigan > 0) {
            hpHeigan -= attackPower;

            if (activeCloud) {
                hpPlayer -= 3500;
                activeCloud = false;
                if (hpPlayer <= 0) {
                    break;
                }
            }

            if (hpHeigan <= 0) {
                break;
            }
            String[] tokens = scanner.nextLine().split("\\s+");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean[][] chamber = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < chamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < chamber[row].length) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }

            if (chamber[startPlRow][startPlCol]) {
                if (isRowValid(chamber, startPlRow - 1) && !chamber[startPlRow - 1][startPlCol]) {
                    startPlRow--;
                } else if (isColValid(chamber, startPlCol + 1) && !chamber[startPlRow][startPlCol + 1]) {
                    startPlCol++;
                } else if (isRowValid(chamber, startPlRow + 1) && !chamber[startPlRow + 1][startPlCol]) {
                    startPlRow++;
                } else if (isColValid(chamber, startPlCol - 1) && !chamber[startPlRow][startPlCol - 1]) {
                    startPlCol--;
                }

                if (chamber[startPlRow][startPlCol]) {
                    switch (spell) {
                        case "Cloud":
                            hpPlayer -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            hpPlayer -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (hpHeigan > 0) {
            System.out.printf("Heigan: %.2f%n", hpHeigan);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (hpPlayer > 0) {
            System.out.printf("Player: %.0f%n", hpPlayer);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }
        System.out.printf("Final position: %d, %d%n",
                startPlRow, startPlCol);

    }

    private static boolean isColValid(boolean[][] chamber, int startCol) {
        return startCol >= 0 && startCol < chamber.length;
    }

    private static boolean isRowValid(boolean[][] chamber, int startRow) {
        return startRow >= 0 && startRow < chamber[startRow].length;
    }
}
