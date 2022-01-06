package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("B:\\input.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        scanner.close();
        writer.close();

    }
}
