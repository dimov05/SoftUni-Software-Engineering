package SetsAndMapsAdvanced;


import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new TreeMap<>();
        while(countStudents-- > 0){
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double averageScore = 0.0;
            for(double v:grades){
                averageScore+=v;
            }
            averageScore /= grades.length;
            students.put(name,averageScore);
        }
        students.forEach((key, value) -> System.out.printf("%s is graduated with " + value + "%n",key));

    }
}
