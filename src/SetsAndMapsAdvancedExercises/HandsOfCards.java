package SetsAndMapsAdvancedExercises;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Set<String>> players = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("JOKER")) {
                break;
            }
            String[] deck = input.split(": ");
            String name = deck[0];
            String[] cardList = deck[1].split(", ");
            Set<String> cards = new HashSet<>();
            players.putIfAbsent(name, cards);
            for (String card : cardList) {
                players.get(name).add(card);
            }
        }
        players.forEach((key, value) -> {
            AtomicInteger sum = new AtomicInteger();
            value.forEach((card) -> {
                int currentSum = 0;
                if (card.length() == 2) {
                    if (Character.isDigit(card.charAt(0))) {
                        int num = Integer.parseInt(String.valueOf(card.charAt(0)));
                        currentSum += num;
                        char symbol = card.charAt(1);
                        currentSum = getCurrentSum(currentSum, symbol);
                    } else {
                        char first = card.charAt(0);
                        currentSum = getCurrentSumForChars(currentSum, first);
                        char symbol = card.charAt(1);
                        currentSum = getCurrentSum(currentSum, symbol);
                    }
                } else if (card.length() == 3) {
                    int num = Integer.parseInt(card.substring(0, 2));
                    char symbol = card.charAt(2);
                    currentSum += num;
                    currentSum = getCurrentSum(currentSum, symbol);
                }
                sum.addAndGet(currentSum);
            });
            System.out.println(key + ": " + sum);
        });
    }

    private static int getCurrentSumForChars(int currentSum, char first) {
        switch (first) {
            case 'J':
                currentSum += 11;
                break;
            case 'Q':
                currentSum += 12;
                break;
            case 'K':
                currentSum += 13;
                break;
            case 'A':
                currentSum += 14;
                break;
        }
        return currentSum;
    }

    private static int getCurrentSum(int currentSum, char symbol) {
        switch (symbol) {
            case 'S':
                currentSum *= 4;
                break;
            case 'H':
                currentSum *= 3;
                break;
            case 'D':
                currentSum *= 2;
                break;
            case 'C':
                break;
        }
        return currentSum;
    }
}
