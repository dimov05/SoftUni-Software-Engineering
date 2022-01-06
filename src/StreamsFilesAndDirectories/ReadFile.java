package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;


public class ReadFile {
    public static void main(String[] args) {


        try (FileInputStream inputStream = new FileInputStream("B:\\input.txt")) {
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
