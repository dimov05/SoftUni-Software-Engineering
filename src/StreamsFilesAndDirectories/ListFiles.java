package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        String fileName = "B:/Files-and-Streams";
        File file = new File(fileName);
        File[] innerFiles = file.listFiles();

        if (innerFiles != null) {
            for (File innerFile : innerFiles) {
                System.out.printf("%s: [%d]%n",
                        innerFile.getName(), innerFile.length());
            }
        }
    }
}
