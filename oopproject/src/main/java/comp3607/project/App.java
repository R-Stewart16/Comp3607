package comp3607.project;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
// Steps from
public final class App {

    private App() {

    }

    public static void readCSVFile(){ // locates the CSV file in folder and reads the contents of the CSV
        try{
            File currDirectory = new File("oopproject/Sample files and CSVs-20211111/sample1/sample1"); // filepath to folder with all files

        /*  for (File file: currDirectory.listFiles()){
                System.out.println(file.getName());
            } */
            for (File file: currDirectory.listFiles()){ //
                String filename = file.getName();
    
                if(filename.endsWith(".csv")){
                    File studentData = new File ("oopproject/Sample files and CSVs-20211111/sample1/sample1" + "/" + filename);
                    Scanner scan = new Scanner(studentData);
                    scan.nextLine(); //skips header

                    List<Student> students = new ArrayList<Student>();
                    String line;
                    String[] temp = new String[12];

                    while (scan.hasNextLine()){
                        line = scan.nextLine();

                        temp = line.split(",");
                        for (int i=0; i<temp.length; i++){
                            System.out.print(temp[i]);
                            System.out.print("apples");
                        }
                        System.out.println("\n");
                        System.out.println(temp.length);

                        /* String pID = temp[0].replace("Participant", "");
                        String name = temp[1];
                        String sID = temp[2];
                        String email = temp[3];
                        String status = temp[4];
                        String grade = temp[5];
                        String maxGrade = temp[6];
                        String changeGrade = temp[7];

                        String dayModified;
                        String dateModified;
                        String timeModified;
                        int count;

                        if (temp[8] == "-"){
                            dayModified = " ";
                            dateModified = " ";
                            timeModified = " ";
                            count = 9;
                        }
                        else{
                            dayModified = temp[8];
                            dateModified = temp[9];
                            timeModified = temp[10];
                            count = 11;
                        }
                        String feedback = temp[count];

                        Student s = new Student(pID, name, sID, email, status, grade, maxGrade, changeGrade, dayModified, dateModified, timeModified, feedback);
                        students.add(s);
                        System.out.println("apples");
                        System.out.println(s.toString()); */
                    } //Hello
                    
                    scan.close();
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }


    // https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    // credit to the above link for the code

    /* public static void listFilesForFolder(final File folder) {
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
    */
    public static void main(String[] args) throws IOException {
        
        System.out.println("Hello World!");
        // ========================[STEP 1] read CSV file=========================================
        readCSVFile();

        //========================================================================================
        final File folder = new File("FilesToRename");

        /* listFilesForFolder(folder);
        // ========================[ STEP 5] create folder=============================

        File nestedFolder = new File(folder + "/renamedFiles");
        if (folder.exists()) {
            // nestedFolder.createNewFile();//needed to create a file
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }
        // ===============================================================
        // ArrayList<File> files = new ArrayList<>();
        // ========================[ STEP 6] rename files in filestoRename=============================
        renameFiles(nestedFolder, folder);
        */
    }
    // Hewllo
    
}
