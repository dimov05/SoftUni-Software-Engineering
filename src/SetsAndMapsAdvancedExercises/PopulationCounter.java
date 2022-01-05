package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesOnly = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("report")) {
                break;
            }
            String[] info = input.split("\\|");
            String country = info[1];
            String city = info[0];
            Long population = Long.parseLong(info[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countriesOnly.put(country, 0L);
            }
            countriesOnly.put(country, countriesOnly.get(country) + population);

            if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, population);
            }
        }
        countries.entrySet().stream()
                .sorted((c1, c2) ->
                        countriesOnly.get(c2.getKey()).compareTo(countriesOnly.get(c1.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n",
                            country.getKey()
                            , countriesOnly.get(country.getKey()));
                    country.getValue().entrySet().stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n",
                                    city.getKey()
                                    , city.getValue()));
                });
    }
}
/* Population Counter
So many people! It’s hard to count them all. But that’s your job as a statistician. You get raw data for a given city, and you need to aggregate it.
On each input line you’ll be given data in format: "city|country|population". There will be no redundant whitespaces anywhere in the input. Aggregate the data by country and by city and print it on the console. For each country, print its total population and on separate lines the data for each of its cities. Countries should be ordered by their total population in descending order and within each country, the cities should be ordered by the same criterion. If two countries/cities have the same population, keep them in the order in which they were entered. Check out the examples; follow the output format strictly!
Input
•	The input data should be read from the console.
•	It consists of a variable number of lines and ends when the command "report" is received.
•	The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
•	The output should be printed on the console.
•	Print the aggregated data for each country and city in the format shown below.
Constraints
•	The name of the city, country and the population count will be separated from each other by a pipe ('|').
•	The number of input lines will be in the range [2 … 50].
•	A city-country pair will not be repeated.
•	The population count of each city will be an integer in the range [0 … 2 000 000 000].
•	Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.
Examples
Input	Output
Sofia|Bulgaria|1000000
report	Bulgaria (total population: 1000000)
=>Sofia: 1000000
Sofia|Bulgaria|1
Veliko Turnovo|Bulgaria|2
London|UK|4
Rome|Italy|3
report	UK (total population: 4)
=>London: 4
Bulgaria (total population: 3)
=>Veliko Tarnovo: 2
=>Sofia: 1
Italy (total population: 3)
=>Rome: 3
 */