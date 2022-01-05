package SetsAndMapsAdvancedExercises;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> materials = new TreeMap<>();
        materials.put("motes", 0);
        materials.put("shards", 0);
        materials.put("fragments", 0);
        TreeMap<String, Integer> junk = new TreeMap<>();
        String legendaryItem;
        while (materials.get("motes") < 250
                && materials.get("fragments") < 250
                && materials.get("shards") < 250) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length; i += 2) {
                int qty = Integer.parseInt(input[i]);
                String matName = input[i + 1].toLowerCase(Locale.ROOT);
                switch (matName) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        materials.put(matName, materials.get(matName) + qty);
                        break;
                    default:
                        junk.putIfAbsent(matName, 0);
                        junk.put(matName, junk.get(matName) + qty);
                        break;
                }

                if (ifEnoughMats(materials)) break;
            }
        }

        if (materials.get("shards") >= 250) {
            legendaryItem = "Shadowmourne";
            materials.put("shards", materials.get("shards") - 250);
        } else if (materials.get("motes") >= 250) {
            legendaryItem = "Dragonwrath";
            materials.put("motes", materials.get("motes") - 250);
        } else {
            legendaryItem = "Valanyr";
            materials.put("fragments", materials.get("fragments") - 250);
        }

        System.out.println(legendaryItem + " obtained!");
        materials.entrySet().stream().sorted((q1, q2) -> q2.getValue().compareTo(q1.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n",
                        e.getKey(), e.getValue())
                );

        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static boolean ifEnoughMats(TreeMap<String, Integer> materials) {
        return materials.get("shards") >= 250 || materials.get("motes") >= 250
                || materials.get("fragments") >= 250;
    }
}
/*Legendary Farming
You’ve beaten all the content and the last thing left to accomplish its own a legendary item. However, it’s a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible items are:
•	Shadowmourne – requires 250 Shards;
•	Valanyr – requires 250 Fragments;
•	Dragonwrath – requires 250 Motes;
Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes, ordered by quantity in descending order, each on a new line. Finally, print the collected junk items, in alphabetical order.
Input
•	Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
Output
•	On the first line, print the obtained item in format {Legendary item} obtained!
•	On the next three lines, print the remaining key materials in descending order by quantity
o	If two key materials have the same quantity, print them in alphabetical order
•	On the final several lines, print the junk items in alphabetical order
o	All materials are printed in format {material}: {quantity}
o	All output should be lowercase, except the first letter of the legendary
Constraints
•	The quantity-material pairs are between 1 and 25 per line.
•	The number of lines is in range [1..10]
•	All materials are case-insensitive.
•	Allowed working time: 0.25s
•	Allowed memory: 16 MB
Examples
Input	Output
3 Motes 5 stones 5 Shards
6 leathers 255 fragments 7 Shards	Valanyr obtained!
fragments: 5
shards: 5
motes: 3
leathers: 6
stones: 5
123 silver 6 shards 8 shards 5 motes
9 fangs 75 motes 103 MOTES 8 Shards
86 Motes 7 stones 19 silver	Dragonwrath obtained!
shards: 22
motes: 19
fragments: 0
fangs: 9
silver: 123
Legendary Farming
You’ve beaten all the content and the last thing left to accomplish its own a legendary item. However, it’s a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible items are:
•	Shadowmourne – requires 250 Shards;
•	Valanyr – requires 250 Fragments;
•	Dragonwrath – requires 250 Motes;
Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes, ordered by quantity in descending order, each on a new line. Finally, print the collected junk items, in alphabetical order.
Input
•	Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
Output
•	On the first line, print the obtained item in format {Legendary item} obtained!
•	On the next three lines, print the remaining key materials in descending order by quantity
o	If two key materials have the same quantity, print them in alphabetical order
•	On the final several lines, print the junk items in alphabetical order
o	All materials are printed in format {material}: {quantity}
o	All output should be lowercase, except the first letter of the legendary
Constraints
•	The quantity-material pairs are between 1 and 25 per line.
•	The number of lines is in range [1..10]
•	All materials are case-insensitive.
•	Allowed working time: 0.25s
•	Allowed memory: 16 MB
Examples
Input	Output
3 Motes 5 stones 5 Shards
6 leathers 255 fragments 7 Shards	Valanyr obtained!
fragments: 5
shards: 5
motes: 3
leathers: 6
stones: 5
123 silver 6 shards 8 shards 5 motes
9 fangs 75 motes 103 MOTES 8 Shards
86 Motes 7 stones 19 silver	Dragonwrath obtained!
shards: 22
motes: 19
fragments: 0
fangs: 9
silver: 123
*/
