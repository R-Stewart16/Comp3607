package comp3607.project;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

// Steps from gather room 1
public final class App {

    private App() {
    }

    // https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    // credit to the above link for the code

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
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

    public static void renameFiles(File nestedFolder, File folder) {// this user made function is used to rename all the files in the filestorenamefolder //Working
        double randomNum = Math.random();
        File namingConvention2 = new File(nestedFolder + "/" + randomNum + ".pdf");
        
        for (File file : folder.listFiles()) {
            if (file.isFile() && (folder.listFiles() != null)) {
                file.renameTo(namingConvention2);
                System.out.println(file + " is renamed");
                renameFiles(nestedFolder, folder);
            } else
                System.out.println(file + " this is not a file");
        }

    }

    public static void main(String[] args) throws IOException {
        
        System.out.println("Hello World!");

        final File folder = new File("oopproject/FilesToRename");

        listFilesForFolder(folder);

        // ========================[ STEP 5] create folder=============================

        File nestedFolder = new File(folder + "/renamedFiles");

        Scanner csv = new Scanner(new File("oopproject/FilesToRename/Sample 1 CSV.csv")); 

        if (folder.exists()) {
            // nestedFolder.createNewFile();//needed to create a file
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }

        /*
        System.out.println("");
        System.out.println("Printing CSV");

        while(csv.hasNext()){
            System.out.println(csv.nextLine());
        }
        */

        // ===============================================================
        // ArrayList<File> files = new ArrayList<>();
        // ========================[ STEP 6] rename files in filestoRename=============================
        //renameFiles(nestedFolder, folder);

    }

}
