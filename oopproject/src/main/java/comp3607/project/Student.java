package comp3607.project;

import java.util.ArrayList;

public class Student {
    
    private ArrayList<String> name;
    private String participantID;
    private String studentID;
    private ArrayList<String> assignments;

    public Student(String id){
        this.participantID = id;
    }

    public void addName(String name){
        this.name.add(name);
    }

    public void addStudentID(String id){
        
    }


}
