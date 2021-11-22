package refactor.app;

import java.util.*;

public class Student {

    private ArrayList<String> names;
    private String participantID;
    private String emailAddress;
    private ArrayList<String> assignments;
    private String studentID;

    public Student() {

    }
    public Student(String participantID, String studentID){
        this.participantID = participantID;
        this.studentID = studentID;
    }
    
    public void Student(String id) {
        // TODO implement here
    }

    

    public void addName(String name) {
        // TODO implement here
    }

    public void addEmailAddress(String email) {
        // TODO implement here
    }

    public void addAssignment(String asg) {
        // TODO implement here
    }

    public ArrayList<String> getNames() {
        // TODO implement here
        return null;
    }

    public String getStudentID() {
        // TODO implement here
        return "";
    }

    public String getParticipantID() {
        // TODO implement here
        return "";
    }

    public String getAssignments() {
        // TODO implement here
        return "";
    }

    public String getEmailAddress() {
        // TODO implement here
        return "";
    }

}