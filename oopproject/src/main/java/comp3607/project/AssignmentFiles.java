package comp3607.project;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentFiles {
    private String renamedFileName = new String();
    private String fName = new String(); // filename
    private String[] fNameDelimited;
    private ArrayList<Student> allStudents = new ArrayList<>();
    private App a = new App();
    private static int studentIndex;
    private ArrayList<String> studentName = new ArrayList<>(); // full Name
    private String studentIdentifier = new String();
    private String studentID = new String();
    private String studentEmail = new String();

    public AssignmentFiles(String fileName) {
        this.fName = fileName;
        splitFname();

        this.allStudents = a.getStudents();
        setFileDetails();
    }

    private void splitFname() {
        this.fNameDelimited = fName.split("[_ -.,\\s+]"); // https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
    }

    // getters
    public String getFileName() {
        return fName;
    }

    public String getRenamedFileName() {
        return renamedFileName;
    }

    public String[] getDelimited() {
        return fNameDelimited;
    }

    public ArrayList<String> getStudentName() {
        return studentName;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    private void extract() {

        for (Student temp : allStudents) {
            for (int i = 0; i < fNameDelimited.length; i++) {
                // do something
                if (fNameDelimited[i].equals(temp.getParticipantID())
                        || fNameDelimited[i].equals(temp.getEmailAddress()) || fNameDelimited[i]
                                .equals(temp.getStudentID()) /* || fNameDelimited[i].equals(temp.getNames()) */ ) {

                    this.studentIdentifier = temp.getParticipantID();
                    this.studentID = temp.getStudentID();
                    this.studentEmail = temp.getEmailAddress();
                    this.studentName = temp.getNames();

                }
            }
        }
    }

    public void setFileDetails() {
        extract();
        renameFile();
    }

    public void renameFile() {
        String newName = new String();
        for (int i = 0; i < studentName.size(); i++) {
            newName += studentName.get(i);
            newName += " ";
        }
        newName = newName.trim();
        newName += "_" + studentIdentifier + "_";
        newName += "assignsubmission_file_";
        newName += fName;

        if (fName.endsWith(".pdf")) {
            newName += ".pdf";
        }

        if (fName.endsWith(".docx")) {
            newName += ".docx";
        }

        this.renamedFileName = newName;
    }

    public String toString() {
        String output = "FileName: " + fName + "\nDelimited:";
        output = output + (Arrays.toString(fNameDelimited)) + "\n\n";

        output += "\tIdentifier: " + studentIdentifier + "\n";
        output += "\tStudent Name: " + (studentName.toString()) + "\n";
        output += "\tEmail Address: " + studentEmail + "\n";
        output += "\t\t\tRenamed File: " + renamedFileName + "\n";
        output += "\tStudent ID: " + studentID + "\n\n\n\n";

        /*
         * output+="Identifier: "+extractIdentifier()+"\n";
         * output+="Email Address: "+extractEmail()+"\n";
         * output+="Student ID: "+extractID()+"\n\n\n\n";
         */

        return output;
    }

}
