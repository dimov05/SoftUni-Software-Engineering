package DefiningClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Car> allCars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s");
            String brand = input[0];
            String model = input[1];
            int hp = Integer.parseInt(input[2]);

            Car car = new Car(brand, model, hp);

            allCars.add(car);
        }
        allCars.forEach(c -> System.out.println(c.carInfo()));
    }
}
