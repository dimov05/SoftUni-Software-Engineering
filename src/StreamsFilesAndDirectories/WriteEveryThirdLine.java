package StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("B:\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int lineNumber = 1;
        String line = reader.readLine();
        while (line != null) {
            if (lineNumber % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            lineNumber++;
            line = reader.readLine();
        }
        writer.flush();
        writer.close();
    }
}
