package ExamExercising;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> madeCocktails = new TreeMap<>();
        String[] inputIngredients = scanner.nextLine().split("\\s+");
        String[] inputFreshness = scanner.nextLine().split("\\s+");
        madeCocktails.putIfAbsent("Pear Sour", 0);
        madeCocktails.putIfAbsent("The Harvest", 0);
        madeCocktails.putIfAbsent("Apple Hinny", 0);
        madeCocktails.putIfAbsent("High Fashion", 0);


        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (int i = inputIngredients.length - 1; i >= 0; i--) {
            int currentNum = Integer.parseInt(inputIngredients[i]);
            if (currentNum != 0) {
                ingredients.push(currentNum);
            }
        }
        for (int i = inputFreshness.length - 1; i >= 0; i--) {
            int curr = Integer.parseInt(inputFreshness[i]);
            freshness.offer(curr);
        }

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int first = ingredients.peekFirst();
            int fresh = freshness.peek();
            double level = first * fresh;
            String cocktailName;
            if (levelIsEnough(level)) {
                cocktailName = getCocktailName(level);
                ingredients.pop();
                freshness.pollFirst();
                madeCocktails.put(cocktailName, madeCocktails.get(cocktailName) + 1);
            } else {
                freshness.pollFirst();
                int inc = ingredients.peek() + 5;
                ingredients.pop();
                ingredients.addLast(inc);
            }
        }
        AtomicBoolean allCocktailsReady = new AtomicBoolean(true);
        madeCocktails.forEach((key, value) -> {
            if (value == 0) {
                allCocktailsReady.set(false);
            }
        });
        if (allCocktailsReady.get()) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int leftIngredients = ingredients.stream().mapToInt(i -> i).sum();
        if (leftIngredients > 0) {
            System.out.printf("Ingredients left: %d%n", leftIngredients);
        }
        madeCocktails.forEach((key, value) -> {
            if (value > 0) {
                System.out.println(toString(key, value));
            }
        });
    }

    private static String toString(String key, int value) {
        return String.format("# %s --> %d", key, value);
    }

    private static String getCocktailName(double level) {
        if (level == 150) {
            return "Pear Sour";
        } else if (level == 250) {
            return "The Harvest";
        } else if (level == 300) {
            return "Apple Hinny";
        } else {
            return "High Fashion";
        }
    }

    private static boolean levelIsEnough(double level) {
        return level == 150 || level == 250 || level == 300 || level == 400;
    }
}
