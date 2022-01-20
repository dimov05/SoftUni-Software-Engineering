package GenericsExercises.GenericsBox.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    String toAdd = tokens[1];
                    customList.add(toAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    customList.remove(indexToRemove);
                    break;
                case "Contains":
                    String contains = tokens[1];
                    System.out.println(customList.contains(contains));
                    break;
                case "Swap":
                    int indexFirst = Integer.parseInt(tokens[1]);
                    int indexSecond = Integer.parseInt(tokens[2]);
                    customList.swap(indexFirst, indexSecond);
                    break;
                case "Greater":
                    String greater = tokens[1];
                    long count = customList.countGreaterThan(greater);
                    System.out.println(count);
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
