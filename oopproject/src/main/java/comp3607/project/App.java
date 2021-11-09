package comp3607.project;

import java.util.*;
import java.io.File;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    //https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    // credit to the above link for the code
    
    public static void  listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        final File folder = new File("FilesToRename");
        listFilesForFolder(folder);
    }
}
