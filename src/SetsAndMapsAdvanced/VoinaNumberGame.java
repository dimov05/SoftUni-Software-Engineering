package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        for(int i =0;i<20;i++){
            first.add(scanner.nextInt());
        }
        for(int i =0;i<20;i++){
            second.add(scanner.nextInt());
        }
        int rounds = 1;

        while (rounds++<=50){
            int firstCard = first.iterator().next();
            first.remove(firstCard);
            int secondCard = second.iterator().next();
            second.remove(secondCard);

            if(firstCard>secondCard){
                first.add(firstCard);
                first.add(secondCard);
            } else if (firstCard<secondCard){
                second.add(firstCard);
                second.add(secondCard);
            }
            if(first.isEmpty()|| second.isEmpty()){
                break;
            }
        }
        if(first.size() > second.size()){
            System.out.println("First player win!");
        } else if(second.size() > first.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
