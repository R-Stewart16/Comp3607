package oop.project;
import java.util.*;
import java.io.File;
import java.io.IOException;

public final class App {
    private App() {
    }

    // https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    // credit to the above link for the code

    public static void listFilesOfFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesOfFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }// read names of assignment files [STEP 2]

    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        final File folder = new File("FilesToRename");

        listFilesOfFolder(folder);

        // ======================[ STEP 5] create folder===================
        File nestedFolder = new File(folder + "/renamedFiles");
        if (folder.exists()) {
            // nestedFolder.createNewFile();//needed to create a file
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }
        // ===============================================================
       
    }
}
