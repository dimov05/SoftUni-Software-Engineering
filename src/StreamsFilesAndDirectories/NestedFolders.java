package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        String fileName = "B:/Files-and-Streams";
        File root = new File(fileName);

        int count = 0;
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();

            if (nestedFiles != null) {
                for (File nestedFile : nestedFiles) {
                    if (nestedFile.isDirectory()) {
                        dirs.offer(nestedFile);
                    }
                }
            }
            count++;
            System.out.println(current.getName());

        }
        System.out.printf("%d folders", count);
    }
}
