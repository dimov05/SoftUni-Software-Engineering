package ExerciseStreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CapitalLetters {
    public static void main(String[] args) throws IOException {
        String fileName = "B:\\SoftUni\\input.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String line = reader.readLine();

        while (line != null) {
            for (char ch : line.toCharArray()) {
                writer.write(Character.toUpperCase(ch));
            }
            writer.newLine();
            line = reader.readLine();
        }
        writer.close();
    }
}
