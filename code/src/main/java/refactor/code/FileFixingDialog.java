package refactor.code;

import java.util.*;
import java.io.File;

public class FileFixingDialog implements Mediator {

    private ArrayList<AssignmentFile> files; // changed from collection to arraylist
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<ProblemSubmissionFile> problemfiles;

    public FileFixingDialog() {

    }

    public void listStudents() { // can split into smaller methods...
        File currentDir = new File("code/FilesToRename");
        String csvPath = new String();

        for (File file : currentDir.listFiles()) {
            if (file.getName().endsWith(".csv")) {
                csvPath = file.getPath();
            }
        }

        try {
            File csvFile = new File(csvPath);

            Scanner scan = new Scanner(csvFile);
            scan.nextLine(); // skips header

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

                Student tempStudent;
                // Creating an Array of all names a student might have and adding that to the
                // Names Arraylist in Students
                temp[1] = temp[1].trim();
                names = temp[1].split("\\s");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].trim();
                    // students.addName(names[i].trim());
                }

                // Adding the student ID
                temp[2] = temp[2].trim();
                // students.addStudentID(temp[2]);

                // Adding email address
                temp[3] = temp[3].trim();
                // students.addEmailAddress(temp[3]);

                // students.add(students);
                tempStudent = new Student(tempSubStrings[1], temp[2], names, temp[3]); // csv -- participantID, full
                                                                                       // name, id, email.

                students.add(tempStudent);
            }
            scan.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // System.out.println("File not found");
    }

    public void notify(Object sender, Object event) {
        // TODO implement here
    }

    public ArrayList<Student> getStudents() {
        if (students.isEmpty())
            listStudents();
        return this.students;
    }

    public ArrayList<AssignmentFile> getAssignmentFiles() {
        return this.files;
    }
}