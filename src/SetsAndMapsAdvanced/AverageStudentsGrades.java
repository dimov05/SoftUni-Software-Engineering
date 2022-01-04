package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String name = scanner.next();
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(scanner.nextDouble());
        }
        students.forEach((key, value) -> {
            double sum = 0;
            for (Double number : value) {
                sum += number;
            }
            double avgSum = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });


    }
}
