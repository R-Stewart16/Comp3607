package refactor.code;

import java.util.*;

public class Student {

    private ArrayList<String> names;
    private String participantID;
    private String emailAddress;
    private String studentSubmission; 
    private String studentID;
    private boolean submitted;

    public Student(String participantID, String studentID, String[] names, String email) {
        this.names = new ArrayList<String>();
        createArraylistOfNames(names);
        this.participantID = participantID;
        this.studentID = studentID;
        this.emailAddress = email;
        this.submitted = false;
    }

    private void createArraylistOfNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            this.names.add(names[i]);
        }
    }

    public void storeStudentSubmission(String submission) {
        this.studentSubmission = submission;
        submitted = true;
    }

    public ArrayList<String> getNames() {
        return names;
    }


    public String getStudentID() {
        return studentID;
    }

    public String getParticipantID() {
        return participantID;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getAssignmentFileName() {
        return studentSubmission;
    }

    public boolean getSubmissionState() {
        return submitted;
    }

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