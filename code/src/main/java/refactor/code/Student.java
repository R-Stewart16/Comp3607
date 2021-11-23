package refactor.code;

import java.util.*;

public class Student {

    private ArrayList<String> names;
    private String[] studentNames;  // primitive array

    private String participantID;
    private String emailAddress;

    private AssignmentFile studentSubmission;   // assumes student can only submit one file. 
    //private ArrayList<String> assignments;
    private String studentID;

    private boolean submitted;      //check over

    public Student(String participantID, String studentID, String[] names, String email){
        this.participantID = participantID;
        this.studentID = studentID;
        this.studentNames = names;
        this.emailAddress = email;
    }
    

/*
    public void addName(ArrayList<String> name) {
        this.names = name;
    }

    public void addEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void addAssignment(String asg) {
        //check over
    }
*/

    public void storeStudentSubmission(AssignmentFile submission){
        this.studentSubmission = submission;
        submitted = true;
    }
    
    public ArrayList<String> getNames() {
        return this.names;
    }

    public String[] getNamesArr() {
        return this.studentNames;
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
        String fileName = studentSubmission.getFileName();
        return fileName;
    }

    public boolean getSubmissionState(){
        return submitted;
    }

    public String toString(){
        String details = "";
        details += "Participant ID: "+ participantID + " ";
        details += "Student ID: "+ studentID + " ";
        details += "Student names: ";
        for (String n: studentNames){
            details += n + " ";
        }  
        return details;
    }

}