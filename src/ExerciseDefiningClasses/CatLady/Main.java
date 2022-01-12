package ExerciseDefiningClasses.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    double earSize = Double.parseDouble(tokens[2]);
                    cat = new Cat.Siamese(name, earSize);
                    break;
                case "Cymric":
                    double lengthFur = Double.parseDouble(tokens[2]);
                    cat = new Cat.Cymric(name, lengthFur);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(tokens[2]);
                    cat = new Cat.StreetExtraordinaire(name, decibels);
                    break;
            }
            cats.put(name, cat);

            input = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        for (Map.Entry<String, Cat> cat : cats.entrySet()) {
            if (cat.getKey().equals(nameToPrint)) {
                System.out.println(cat.getValue());
            }
        }

    }
}
