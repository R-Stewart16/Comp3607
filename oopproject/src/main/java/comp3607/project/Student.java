package comp3607.project;

import java.util.ArrayList;

public class Student{

    private ArrayList<String> names;
    
    private String participantID;       //identifier
    private String studentID;
    private String emailAddress;
    private ArrayList<String> assignments;

    public Student(String id){
        this.participantID = id;
        names = new ArrayList<String>();
        assignments = new ArrayList<String>();
    }

    //Setters
    public void addName(String name){
        names.add(name);
    }

    public void addStudentID(String id){
        studentID = id;
    }

    public void addEmailAddress(String email){
        emailAddress = email;
    }

    public void addAssignment (String asg){
        assignments.add(asg);
    }


    //Getters
    public ArrayList<String> getNames(){
        return names;
    }
    public String getStudentID(){
        return studentID;
    }

    public String getParticipantID(){
        return participantID;
    }

    public ArrayList<String> getAssignments(){
        return assignments;
    }

    public String getEmailAddress(){
        return emailAddress;
    }



}
    
