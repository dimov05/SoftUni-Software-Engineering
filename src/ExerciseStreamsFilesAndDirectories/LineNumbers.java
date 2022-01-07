package ExerciseStreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String fileName = "B:\\SoftUni\\inputLineNumbers.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        int counter = 1;
        while (line != null) {
            writer.write(counter + ". " + line);
            writer.newLine();
            counter++;

            line = reader.readLine();
        }
        writer.close();
    }
}
