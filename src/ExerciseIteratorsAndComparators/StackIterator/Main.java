package ExerciseIteratorsAndComparators.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack customStack = new CustomStack();

        String[] initialValues = scanner.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0]
                .split("\\s+")[1]));

        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].replaceAll(" ","")));
        }

        String line = "";

        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Pop":
                    try {
                        customStack.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Push":
                    int el = Integer.parseInt(tokens[1]);
                    customStack.push(el);
                    break;
            }
        }
        printElements(customStack);
        printElements(customStack);

    }

    private static void printElements(CustomStack customStack) {
        for (int element : customStack) {
            System.out.println(element);
        }
    }
}
