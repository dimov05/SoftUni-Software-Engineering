package SetsAndMapsAdvanced;


import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (true) {
            String[] input = scanner.nextLine().split(", ");
            if (input[0].equals("END")) {
                break;
            }
            String direction = input[0];
            String plate = input[1];
            if (direction.equals("IN")) {
                cars.add(plate);
            } else if (direction.equals("OUT")) {
                cars.remove(plate);
            }
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String element : cars) {
                System.out.println(element);
            }
        }
    }
}
