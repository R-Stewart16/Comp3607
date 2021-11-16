package comp3607.project;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Steps from gather room 1
public final class App {
    private ArrayList <AssignmentFiles> files = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<Student>();


    public App(){

    }


    public static String findCSVFilePath() {
        File currentDir = new File("oopproject/FilesToRename");

        for (File file : currentDir.listFiles()) {
            if (file.getName().endsWith(".csv")) {
                return file.getPath();
            }
        }
        System.out.println("File not found");
        return "File not found";
    }

    public static ArrayList<Student> readCSVFile() { // locates the CSV file in folder and reads the contents of the CSV
        //ArrayList<Student> students = new ArrayList<Student>();
        try {

            File studentData = new File(findCSVFilePath());
            Scanner scan = new Scanner(studentData);
            scan.nextLine(); // skips header

            // ArrayList<Student> students = new ArrayList<Student>();
            String line;
            String[] temp = new String[12];
            String[] tempSubStrings = new String[4];
            String[] names = new String[4];

            while (scan.hasNextLine()) {

                line = scan.nextLine();
                temp = line.split(",");

                // Iterate through the array of strings and trims all whitespaces.
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = temp[i].trim();
                }

                // Error checking
                if (temp[0] == "\\s")
                    continue;

                // Seperating the word participants from the digits then using those digits to
                // start a student object
                tempSubStrings = temp[0].split("\\s");

                for (int i = 0; i < tempSubStrings.length; i++) {
                    tempSubStrings[i] = tempSubStrings[i].trim();
                }

                

                Student student = new Student(tempSubStrings[1]);

                

                // Creating an Array of all names a student might have and adding that to the
                // Names Arraylist in Students
                temp[1] = temp[1].trim();
                names = temp[1].split("\\s");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].trim();
                    student.addName(names[i].trim());
                }

                // Adding the student ID
                temp[2] = temp[2].trim();
                student.addStudentID(temp[2]);

                // Adding email address
                temp[3] = temp[3].trim();
                student.addEmailAddress(temp[3]);

                students.add(student);

            }
            scan.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return students;
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public void addAssignments(){
        File currentDir = new File("oopproject/FilesToRename"); // filepath

        for(File file:currentDir.listFiles()){
            String fileName = file.getName();
            files.add(new AssignmentFiles(fileName));
        }

    }

    public void displayAssignmentName(int index){
        for(int i=0; i<25; i++){
            index = i;
            System.out.println(files.get(index).toString());
        }
        
    }

   
    public static void copyFile(File nestedFolder, File folder) throws IOException {
        String path = "oopproject/FilesToRename/renamedFiles/";
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".pdf")) {
                // copy files from folder to nestedFolder
                Files.copy(file.toPath(), (new File(path + file.getName())).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    public static void renameFiles(File nestedFolder) {// user-defined function is used to rename files

    // Convention 2 is "Name1 Name2_CCCCCC_assignsubmission_file_NNNNNN.pdf"        

        for (File file : nestedFolder.listFiles()) {
            //double randomNum = Math.random();
            String fileName = file.getName();
            AssignmentFiles temp = new AssignmentFiles(fileName);
            String renamed = temp.getRenamedFileName();
 


            File namingConvention2 = new File(nestedFolder + "/" + renamed);
            file.renameTo(namingConvention2);
            //File namingConvention3 = new File(nestedFolder + "/" + randomNum + ".docx");
            
            /*
            if (file.getName().endsWith(".pdf")) {
                System.out.println("file: " + file.getName());
                file.renameTo(namingConvention2);
            } 
            else 
                if (file.getName().endsWith(".docx")) {
                    System.out.println("file: " + file.getName());
                //file.renameTo(namingConvention3);
                }
                */

        }
    }

    
    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        ArrayList<Student> students = new ArrayList<Student>();
        students = readCSVFile();// read .csv file
        System.out.println("=====================================================");

        
        // ===============================================================================================

        // ========================================================================================
        final File folder = new File("oopproject/FilesToRename");
        File nestedFolder = new File(folder + "/renamedFiles");

        if (folder.exists()) {
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }


        System.out.println("\n\n\n\n");
        App g = new App();
        g.addAssignments();
        g.displayAssignmentName(1);

        System.out.println("=======================================");
        copyFile(nestedFolder, folder);
        renameFiles(nestedFolder);
        System.out.println("=======================================");
        System.out.println("\n\t\t\t Test file names extraction...");
        System.out.println("=======================================");
        
        g.displayAssignmentName(1);

        System.out.println("=======================================");


        System.out.println("\nTesting Student arraylist...\n");
        System.out.println(g.getStudents().get(15).getEmailAddress());
        System.out.println("\n=======================================");


        

    }

}
