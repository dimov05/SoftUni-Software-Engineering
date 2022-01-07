package ExerciseStreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static int sumVowels = 0;
    public static int sumConsonants = 0;
    public static int punctuation = 0;

    public static void main(String[] args) throws IOException {
        String fileName = "B:\\SoftUni\\input.txt";
        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line = reader.readLine();

        while (line != null) {
            for (char ch : line.toCharArray()) {
                getCounter(ch);
            }
            line = reader.readLine();
        }
        writer.write("Vowels: " + sumVowels);
        writer.newLine();
        writer.write("Consonants: " + sumConsonants);
        writer.newLine();
        writer.write("Punctuation: " + punctuation);

        writer.close();
    }

    private static void getCounter(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                sumVowels++;
                break;
            case '?':
            case '.':
            case ',':
            case '!':
                punctuation++;
            case ' ':
                break;
            default:
                sumConsonants++;
                break;
        }
    }
}
