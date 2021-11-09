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

    public static void  listFilesOfFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesOfFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");

        final File folder = new File("FilesToRename");
        listFilesOfFolder(folder);

            //Attempting to create the nested folder in "FilesToRename". Not working right now.
          String path = "FilesToRename";  
          //Using Scanner class to get the folder name from the user  
          System.out.println("Enter the name of the desired a directory: ");   
          //Instantiate the File class   
          File f1 = new File(path);  
          //Creating a folder using mkdir() method  
          boolean bool = f1.mkdir();  
          if(bool){  
             System.out.println("Folder is created successfully");  
          }else{  
             System.out.println("Error Found!");  
          }  
    }
    
}
