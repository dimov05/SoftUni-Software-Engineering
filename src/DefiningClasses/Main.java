package DefiningClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<CarByBrand> allCars = new ArrayList<>();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            CarByBrand car = new CarByBrand(input[0]);
            if (input.length > 1) {
                car.setModel(input[1]);
                car.setHorsePower(Integer.parseInt(input[2]));
            }
            allCars.add(car);
        }

        allCars.forEach(c -> System.out.println(c.toString()));
    }
}
