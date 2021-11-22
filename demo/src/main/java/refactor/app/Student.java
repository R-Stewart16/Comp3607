package refactor.app;

import java.util.*;

public class Student {

    private ArrayList<String> names;
    private String participantID;
    private String emailAddress;
    private ArrayList<String> assignments;
    private String studentID;

    private boolean submitted;      //check over

    public Student() {

    }

    public Student(String participantID, String studentID){
        this.participantID = participantID;
        this.studentID = studentID;
    }
    

    public void addName(ArrayList<String> name) {
        this.names = name;
    }

    public void addEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void addAssignment(String asg) {
        //check over
    }

    public ArrayList<String> getNames() {
        return this.names;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getParticipantID() {
        return participantID;
    }

    public String getAssignments() {
        //check over
        return "";
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

}