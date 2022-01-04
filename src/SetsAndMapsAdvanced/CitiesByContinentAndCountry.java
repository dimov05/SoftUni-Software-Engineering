package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> cont = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            cont.putIfAbsent(continent, new LinkedHashMap<>());
            cont.get(continent).putIfAbsent(country, new ArrayList<>());
            cont.get(continent).get(country).add(city);
        }
        cont.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((country, cities) -> {
                System.out.printf("  %s -> ", country);
                System.out.println(cities.toString().replaceAll("[\\[\\]]", ""));
            });
        });
    }
}
