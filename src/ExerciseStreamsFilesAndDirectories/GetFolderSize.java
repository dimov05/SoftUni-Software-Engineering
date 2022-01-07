package ExerciseStreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String folderName = "C:/Users/Dimo/Desktop/SoftUni/3.Advanced/Advanced/10. Exercise Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File dir = new File(folderName);
        long size = 0;
        File[] files = dir.listFiles();
        if(files != null){
            for(File file:files){
                if(file.isFile()){
                    size+=file.length();
                }
            }
        }
        System.out.println("Folder size: "+ size);

    }
}
