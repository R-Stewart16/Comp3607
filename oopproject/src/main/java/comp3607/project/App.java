package comp3607.project;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Steps from gather room 1
public final class App {

    private App() {

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
        ArrayList<Student> students = new ArrayList<Student>();
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

                // Seperating the word participants from the digits then useing those digits to
                // start a student object
                tempSubStrings = temp[0].split("\\s");

                for (int i = 0; i < tempSubStrings.length; i++) {
                    tempSubStrings[i] = tempSubStrings[i].trim();
                }

                // System.out.println(temp.length);
                // System.out.println(tempSubStrings.length);

                Student student = new Student(tempSubStrings[1]);

                // System.out.println(student.getParticipantID());

                // Creating an Array of all names a student might have and adding that to the
                // Names Arraylist in Students
                temp[1] = temp[1].trim();
                names = temp[1].split("\\s");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].trim();
                    student.addName(names[i].trim());
                }

                // System.out.println(student.getNames());

                // Adding the student ID
                temp[2] = temp[2].trim();
                student.addStudentID(temp[2]);

                // System.out.println(student.getStudentID());

                // Adding email address
                temp[3] = temp[3].trim();
                student.addEmailAddress(temp[3]);

                // System.out.println(student.getEmailAddress());
                // System.out.println(" ");

                students.add(student);

            }
            // System.out.println(students);
            scan.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return students;
    }

    public static ArrayList<Student> traverseAssignments(ArrayList<Student> students) { // goes through the
                                                                                        // FilesToRename folder and
                                                                                        // assigns files to the
                                                                                        // respective student
        File currentDir = new File("oopproject/FilesToRename"); // filepath
        // for (File f : currentDir.listFiles()) {
        // System.out.println(f.getName());
        // }

        for (File file : currentDir.listFiles()) { // goes through all files in folder
            if ((file.getName().endsWith(".pdf")) || (file.getName().endsWith(".docx"))) { // only looks at .pdf and
                                                                                           // .docx files
                String line = file.getName(); // gets the full filename

                String[] temp;
                String[] tempName = new String[4];
                ArrayList<String> names = new ArrayList<String>();
                String participantID;

                // Separate the filename by _ and stores it in array
                temp = line.split("_");

                /*
                 * for(String t: temp){ System.out.print(t); System.out.print(" "); }
                 * System.out.println(" ");
                 */

                // Storing the names of the student for that filename
                temp[0] = temp[0].trim();
                tempName = temp[0].split(" ");
                for (String name : tempName) {
                    names.add(name);
                }

                // System.out.println(names);

                // Getting participantID from that filename
                temp[1] = temp[1].trim();
                participantID = temp[1];

                for (Student student : students) { // Traversing the entire Students arraylist and getting their full
                                                   // name
                    ArrayList<String> studentName = student.getNames(); // gets the full name of the student in Students
                                                                        // list
                    String pID = student.getParticipantID(); // gets the participantID of the student in Students list

                    if ((studentName.equals(names)) || (pID.equals(participantID))) { // compares the student name/
                                                                                      // participantID in the assignment
                                                                                      // file with the Students list
                        student.addAssignment(line); // if it matches, the assignment filename is added to the
                                                     // assignments list of that student

                        /*
                         * System.out.println(studentName); System.out.println(names);
                         * System.out.println("----------------------------");
                         */
                    }

                    else {
                        continue;
                    }
                }

            }

        }
        return students;
    }

    // https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    // credit to the above link for the code

    /*
     * public static void listFilesForFolder(final File folder) { for (final File
     * fileEntry : folder.listFiles()) { if (fileEntry.isDirectory()) {
     * listFilesForFolder(fileEntry); } else {
     * System.out.println(fileEntry.getName()); } } }// read names of assignment
     * files [STEP 2]
     * 
     * public static ArrayList<File> arraylist(final File folder) { ArrayList<File>
     * files = new ArrayList<>(); for (final File fileEntry : folder.listFiles()) {
     * files.add(fileEntry); } return files; } // To put the files in an array,
     * might use this to renamed files
     */

    public static void renameFiles(File nestedFolder, File folder) {// user-defined function is used to rename files
        double randomNum = Math.random();
        File namingConvention2 = new File(nestedFolder + "/renamedFile" + randomNum + ".pdf");
        // File[] files = folder.listFiles();
        // int length = files.length;
        // for (int i = 0; i < length; i = i + 1) {
        // if (files[i].getName().endsWith(".pdf")) {
        // System.out.println("file: " + files[i].getName());
        // files[i].renameTo(namingConvention2);
        // }
        // }
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".pdf")) {
                System.out.println("file: " + file.getName());
                file.renameTo(namingConvention2);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        // ========================[STEP 1] read CSV
        // file=========================================

        ArrayList<Student> students = new ArrayList<Student>();
        students = readCSVFile();
        System.out.println("=====================================================");

        /*
         * for(Student s: students){ System.out.println(s.getParticipantID());
         * System.out.println(s.getNames()); System.out.println(s.getStudentID());
         * System.out.println(s.getEmailAddress()); System.out.print("\n"); }
         */
        // ==========================================================================================

        // ==========================[STEP 1.5] assign student files to respective
        // student==================

        students = traverseAssignments(students);
        for (Student s : students) {
            System.out.println(s.getParticipantID());
            System.out.println(s.getNames());
            System.out.println(s.getStudentID());
            System.out.println(s.getEmailAddress());
            System.out.println(s.getAssignments());
            System.out.print("\n");
        }
        // ===============================================================================================

        // ========================================================================================
        // final File folder = new File("oopproject/FilesToRename");

        /*
         * listFilesForFolder(folder); // ========================[ STEP 5] create
         * folder=============================
         * 
         * File nestedFolder = new File(folder + "/renamedFiles");
         * 
         * Scanner csv = new Scanner(new
         * File("oopproject/FilesToRename/Sample 1 CSV.csv"));
         * 
         * if (folder.exists()) { // nestedFolder.createNewFile();//needed to create a
         * file nestedFolder.mkdir();// to create a folder/directory
         * System.out.println("Folder created"); }
         * 
         * 
         * System.out.println(""); System.out.println("Printing CSV");
         * 
         * while(csv.hasNext()){ System.out.println(csv.nextLine()); }
         * 
         * 
         * // =============================================================== //
         * ========================[ STEP 6] rename files in filestoRename============
         */
        // renameFiles(nestedFolder, folder);

    }

}
