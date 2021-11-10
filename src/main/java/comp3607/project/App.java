package comp3607.project;

import java.util.*;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Hello world!
 */
// Steps from
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

    public static ArrayList<File> arraylist(final File folder) {
        ArrayList<File> files = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            files.add(fileEntry);
        }
        return files;
    } // To put the files in an array, might use this to renamed files

//     public static void copyfiles(String originalFile, String destFile) {
//         File rootFile = new File(originalFile);
//         ArrayList<File> files = new ArrayList<>();
//         for (final File fileEntry : rootFile.listFiles()) {
//             files.add(fileEntry);
//         }
//         System.out.println(files);
//     } my own code attempting to copy and paste the two files here but pieces missing 

    public static void copyfiles(File from, File to) throws IOException {
        FileUtils.copyFile(from, to);
    }
    // public static void copyFile(String from, String to) throws IOException {// this function suppose the same thing as the above function
    // Path src = Paths.get(from);
    // Path dest = Paths.get(to);
    // Files.copy(src.toFile(), dest.toFile());
    // }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        final File folder = new File("FilesToRename");

        // listFilesOfFolder(folder);
        // ========================[ STEP 5]=============================
        File nestedFolder = new File(folder + "/renamedFiles");
        if (folder.exists()) {
            // nestedFolder.createNewFile();//needed to create a file
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }
        // ===============================================================
        for (File files : arraylist(folder)) {
            // if (folder.exists()) {
            // files.getAbsolutePath();
            // // copy file in filestorename
            // if (nestedFolder.exists()) {
            // copyfiles(files, nestedFolder);

            // }
            // }

        }

    }

}
