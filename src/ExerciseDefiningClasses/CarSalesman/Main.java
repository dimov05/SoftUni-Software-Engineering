package ExerciseDefiningClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = null;
            if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (input.length == 2) {
                engine = new Engine(model, power);
            } else if (input.length == 3) {
                if (input[2].matches("^\\d+$")) {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = input[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.putIfAbsent(model, engine);
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());

        for (int p = 0; p < m; p++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine engine = engineMap.get(input[1]);
            Car car = null;
            if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new Car(model, engine, weight, color);
            } else if (input.length == 2) {
                car = new Car(model, engine);
            } else if (input.length == 3) {
                if (input[2].matches("^\\d+$")) {
                    int weight = Integer.parseInt(input[2]);
                    car = new Car(model,engine,weight);
                } else {
                    String color = input[2];
                    car = new Car(model,engine,color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);

    }
}
