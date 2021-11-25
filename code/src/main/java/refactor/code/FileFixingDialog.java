package refactor.code;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileFixingDialog implements Mediator {

    private ArrayList<AssignmentFile> files;
    private ArrayList<Student> students;
    private AssignmentFile newAssignmentFile;
    private RenameFile rename;
    private NestedFolder nestedFolder;
    private ArrayList<String> missingSubmissions;
    private ArrayList<String> problemSubmissions;
    private String seperator = System.getProperty("file.separator");


    /***
     * Initializes the student arraylist, the assignment files arraylist and the missing and problem submissions arraylist
     */
    public FileFixingDialog() {
        students = new ArrayList<Student>();
        files = new ArrayList<AssignmentFile>();
        missingSubmissions = new ArrayList<String>();
        problemSubmissions = new ArrayList<String>();
    }


    /***
     * Matches the students to assignment Files
     * @param fileName the name of the filename 
     * @return true if the student is matched to the file successfully, false otherwise
     */
    public boolean matchStudents(String fileName) {
        boolean matched = false; // Matching students to assignments
        for (Student s : students) {
            ArrayList<String> idMarkers = new ArrayList<String>();
            idMarkers.add(s.getParticipantID());
            idMarkers.add(s.getStudentID());
            idMarkers.add(s.getEmailAddress());
            // idMarkers.addAll(s.getNames());

            MatchStudentsToAssignment matchingComponent = new MatchStudentsToAssignment();
            if (matchingComponent.match(idMarkers, newAssignmentFile.getDelimited(), fileName)) {
                matched = true;
                s.storeStudentSubmission(fileName);
                missingSubmissions.remove(s.toString());

            } else {
                s.storeStudentSubmission("Submission not found");
            }
        }
        if (!matched)
            problemSubmissions.add(fileName);

        return matched;
    }


    /***
     *  This method notifies all connected components of the change to the FilesToRename folder 
     *  and begins the process of renaming the file.
     */
    public void updateMediator(String fileName, Path path) {
        // find the csv and create an collection of students

        if (students.isEmpty()) {
            createListOfEnrolledStudents(path);
        }

        newAssignmentFile = new AssignmentFile(fileName);
        files.add(new AssignmentFile(fileName));

        // creating new nested folder and copying files
        nestedFolder = new NestedFolder(path);
        File f = new File(path.toString() + seperator + fileName);

        try {
            nestedFolder.copyFile(f);
        } catch (IOException e) {
            System.out.println("Cannot copy file");
        }

        matchStudents(fileName);
        renameFile(fileName);  

        System.out.println("Number of missing files: " + missingSubmissions.size());
        System.out.println("Number of problem files: " + problemSubmissions.size());
        for (String m : problemSubmissions) {
            System.out.println("Problem File details: " + m);
        }
        System.out.println();
    }


    /***
     * 
     * @param filename original file name of the submitted file
    */
    public void renameFile(String fileName){
        rename = new RenameFile(nestedFolder.getNestedFolderPath());
        for (Student s : students) {
            if (s.getSubmissionState() && fileName.equals(s.getAssignmentFileName())) {
                try {
                    rename.changeFileName(s.getNames(), s.getParticipantID(), fileName);
                } catch (Exception e) {
                    System.out.println("rename failed");
                }
            }
        }
    }
    

    /***
     * Finds the path to the csv file
     * @param path the path to the 
     * @return
     */
    public String getCSVPath(Path path){
        File currentDir = new File(path.toString());
        String csvPath = new String();

        for (File file : currentDir.listFiles()) {
            if (file.getName().endsWith(".csv")) {
                csvPath = file.getPath();
            }
        }
        return csvPath;
    }


    /***
     * Populates the student arrayList with information from the csv
     * @param path the path to the csv file in FilesToRename
     */
    public void createListOfEnrolledStudents(Path path) { // can split into smaller methods...
        
        try {
            File csvFile = new File(getCSVPath(path));

            Scanner scan = new Scanner(csvFile);
            scan.nextLine(); // skips header

            String line;
            String[] temp;
            String[] splitPaticipantID;
            String[] names;

            while (scan.hasNextLine()) {
                line = scan.nextLine();
                temp = line.split(",");

                for (int i = 0; i < temp.length; i++) {
                    temp[i] = temp[i].trim();
                } // Iterate through the array of strings and trims all whitespaces.

                // To seperate the word "Participants" from digits
                splitPaticipantID = temp[0].split("\\s");

                Student tempStudent;
                // Creating an Array of all names a student might have and adding that to the
                names = temp[1].split("\\s");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].trim();
                }

                tempStudent = new Student(splitPaticipantID[1], temp[2], names, temp[3]);

                students.add(tempStudent);
                missingSubmissions.add(tempStudent.toString());
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Error: Cannot create list of enrolled students");
        }
    }

}