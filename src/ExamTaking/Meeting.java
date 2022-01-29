package ExamTaking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMatches = 0;

        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        int[] maleArr = getArray(scanner);
        int[] femaleArr = getArray(scanner);

        fillStack(males, maleArr);
        fillQueue(females, femaleArr);

        while (!females.isEmpty() && !males.isEmpty()) {

            if (males.peek().equals(females.peek())) {
                countMatches++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                int currMan = males.peek();
                if (currMan - 2 <= 0) {
                    males.pop();
                } else {
                    males.push(currMan - 2);
                    males.remove(currMan);
                }
            }
        }

        System.out.printf("Matches: %d%n", countMatches);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String leftMales = getStringOutput(males);
            System.out.printf("Males left: %s%n", leftMales);
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String leftFemales = getStringOutput(females);
            System.out.printf("Females left: %s%n", leftFemales);
        }
    }

    private static String getStringOutput(ArrayDeque<Integer> males) {
        StringBuilder sb = new StringBuilder();
        for (int num : males) {
            if (males.size() == 1) {
                sb.append(num);
            } else {
                sb.append(num).append(", ");
                males.pop();
            }
        }
        return sb.toString();
    }

    private static void fillStack(ArrayDeque<Integer> males, int[] maleArr) {
        boolean oneBonus = false;
        for (int num : maleArr) {
            if (num % 25 != 0) {
                if (num > 0) {
                    if (!oneBonus) {
                        males.push(num);
                    } else {
                        oneBonus = false;
                    }
                }
            } else {
                oneBonus = true;
            }
        }
    }

    private static void fillQueue(ArrayDeque<Integer> females, int[] femaleArr) {
        boolean oneBonus = false;
        for (int num : femaleArr) {
            if (num % 25 != 0) {
                if (num > 0) {
                    if (!oneBonus) {
                        females.offer(num);
                    } else {
                        oneBonus = false;
                    }
                }
            } else {
                oneBonus = true;
            }
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
