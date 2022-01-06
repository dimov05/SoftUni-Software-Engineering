package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("B:\\input.txt");

        FileOutputStream outputStream = new FileOutputStream("output.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();
        while (singleByte >= 0) {
            String digits = String.valueOf(singleByte);
            if (digits.equals("10")|| digits.equals("32")) {
                writer.print((char) singleByte);
            } else {
                writer.print(singleByte);

            }

            singleByte = inputStream.read();
        }
        writer.close();
        inputStream.close();
    }
}
