package refactor.code;

import java.util.*;

public class Student {

    private ArrayList<String> names;
    private String participantID;
    private String emailAddress;
    private String studentSubmission;   //assumes student can only submit one file.
    private String studentID;
    private boolean submitted; 

    /**
     * Initialises the attributes of the student
     * 
     * @param participantID the participant ID of the student 
     * @param studentID the student ID of the student
     * @param names the names of the student
     * @param email the email address of the student
     */
    public Student(String participantID, String studentID, String[] names, String email) {
        this.names = new ArrayList<String>();
        createArraylistOfNames(names);
        this.participantID = participantID;
        this.studentID = studentID;
        this.emailAddress = email;
        this.submitted = false;
    }

    /***
     * converts the String array of names to an arraylist of strings
     * @param names the names of the student
     */
    private void createArraylistOfNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            this.names.add(names[i]);
        }
    }

    /***
     * Stores and sets the student as one who submitted an assignment
     * @param submission the file name of the submitted file of the student
     */
    public void storeStudentSubmission(String submission) {
        this.studentSubmission = submission;
        submitted = true;
    }

    /**
     * 
     * @return the names of the student 
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * 
     * @return the student ID of the student 
     */
    public String getStudentID() {
        return studentID;
    }

    /***
     * 
     * @return the participant ID of the student 
     */
    public String getParticipantID() {
        return participantID;
    }

    /**
     * 
     * @return the email address of the student
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * 
     * @return the file name of the submitted assignment
     */
    public String getAssignmentFileName() {
        return studentSubmission;
    }

    /**
     * 
     * @return the submission state of the student
     */
    public boolean getSubmissionState() {
        return submitted;
    }

    /***
     * Outputs information about a student
     */
    public String toString() {
        String details = "";
        details += "Participant ID: " + participantID + " ";
        details += "Student ID: " + studentID + " ";
        details += "Student names: ";
        for (String n : names) {
            details += n + " ";
        }
        return details;
    }

}