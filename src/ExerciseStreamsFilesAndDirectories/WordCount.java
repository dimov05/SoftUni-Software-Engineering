package ExerciseStreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String fileWithWords = "B:\\SoftUni\\words.txt";
        String textFile = "B:\\SoftUni\\text.txt";

        LinkedHashMap<String, Integer> countWords = new LinkedHashMap<>();

        String[] text = Files.readString(Paths.get(textFile))
                .replaceAll(",", "")
                .replaceAll("\\.", "").split("\\s+");
        String[] word = Files.readString(Paths.get(fileWithWords)).split("\\s+");

        for (String w : word) {
            countWords.put(w, 0);
        }
        for (String current : text) {
            if (countWords.containsKey(current)) {
                countWords.put(current, countWords.get(current) + 1);
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
        countWords.forEach((key, value) -> {
            try {
                writer.write(key + " - " + value);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();


    }
}
