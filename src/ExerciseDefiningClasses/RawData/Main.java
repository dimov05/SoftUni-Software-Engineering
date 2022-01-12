package ExerciseDefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> allCars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];

            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            Cargo cargo = new Cargo(weight, type);

            double pressure1 = Double.parseDouble(input[5]);
            int age1 = Integer.parseInt(input[6]);
            double pressure2 = Double.parseDouble(input[7]);
            int age2 = Integer.parseInt(input[8]);
            double pressure3 = Double.parseDouble(input[9]);
            int age3 = Integer.parseInt(input[10]);
            double pressure4 = Double.parseDouble(input[11]);
            int age4 = Integer.parseInt(input[12]);
            Tyres tyres = new Tyres(pressure1, age1, pressure2, age2, pressure3, age3, pressure4, age4);

            Car car = new Car(model, engine, cargo, tyres);

            allCars.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("flamable")) {
            allCars.stream().filter(c -> c.cargo.type.equals(command))
                    .filter(c -> c.engine.power > 250)
                    .forEach(car -> System.out.println(car.model));
        } else {
            allCars.stream().filter(c -> c.cargo.type.equals(command))
                    .filter(car -> car.getTyres().ifLower())
                    .forEach(car -> System.out.println(car.model));
        }
    }
}
