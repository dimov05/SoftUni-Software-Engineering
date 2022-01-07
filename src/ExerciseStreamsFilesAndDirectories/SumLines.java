package ExerciseStreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String fileName = "B:\\SoftUni\\input.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

        String line = reader.readLine();
        while (line != null) {
            long sum = 0;
            for (char ch : line.toCharArray()) {
                sum += ch;
            }
            System.out.println(sum);
            line = reader.readLine();
        }
    }
}
