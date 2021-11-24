package refactor.code;

import java.util.*;

public class Student {

    private ArrayList<String> names;
    private String[] studentNames;  // primitive array

    private String participantID;
    private String emailAddress;

    private String studentSubmission;   // assumes student can only submit one file. 
    //private ArrayList<String> assignments;
    private String studentID;

    private boolean submitted;      //check over

    public Student(String participantID, String studentID, String[] names, String email){
        this.names = new ArrayList<String>();
        createArraylistOfNames(names);
        this.participantID = participantID;
        this.studentID = studentID;
        this.studentNames = names;
        this.emailAddress = email;
        this.submitted = false;
    }

    private void createArraylistOfNames(String[] names){
        for(int i=0; i<names.length; i++){
            this.names.add(names[i]);
        }
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

    public void storeStudentSubmission(String submission){
        this.studentSubmission = submission;
        submitted = true;
    }
    
    public ArrayList<String> getNames() {
        return names;
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
        //String fileName = studentSubmission.getFileName();
        return studentSubmission;
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
        details += "\nSubmitted file is :" +studentSubmission + "\n";
        return details;
    }

}