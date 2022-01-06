package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("B:\\input.txt"));
        Collections.sort(lines);

        Files.write(Paths.get("output.txt"), lines);
    }
}
