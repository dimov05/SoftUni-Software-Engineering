package ExerciseStreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String fileName = "B:\\SoftUni\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        long sum = 0;
        String line = reader.readLine();
        while (line != null) {
            for (char ch : line.toCharArray()) {
                sum += ch;
            }
            line = reader.readLine();
        }
        System.out.println(sum);
    }
}
