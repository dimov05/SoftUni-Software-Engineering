package ExerciseStreamsFilesAndDirectories;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeFiles {
    public static void main(String[] args) throws IOException {
        String fileOne = "B:\\SoftUni\\inputOne.txt";
        String fileTwo = "B:\\SoftUni\\inputTwo.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));

        BufferedReader reader = Files.newBufferedReader(Paths.get(fileOne));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line);
            writer.newLine();
            line = reader.readLine();
        }
        reader = Files.newBufferedReader(Paths.get(fileTwo));
        line = reader.readLine();
        while (line != null) {
            writer.write(line);
            writer.newLine();
            line = reader.readLine();
        }
        writer.close();

    }
}
