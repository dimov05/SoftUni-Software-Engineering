package GenericsExercises.GenericsBox.CountMethodStrings;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(scanner.nextLine());
            box.addValue(input);
        }
        Double check = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreater(check));

    }
}
