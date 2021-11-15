package comp3607.project;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentFiles {
    private String fName = new String();
    private String[] fNameDelimited;
    private ArrayList<Student> allStudents = new ArrayList<>();
    private App a = new App();

    private String studentName = new String();  //full Name 
    private String studentIdentifier = new String();
    private String studentID = new String();
    private String studentEmail = new String();

    public AssignmentFiles(String fileName){
        this.fName = fileName;
        splitFname();

        this.allStudents = a.getStudents();
    }

    private void splitFname(){
        this.fNameDelimited = fName.split("[_ -.,\\s+]");       //https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
    }

    private String extractName(){
        for(Student temp: allStudents){

            for(int i=0; i<fNameDelimited.length; i++){
                //do something 
            }

        }


        return "";
    }

    private String extractIdentifier(){

        return "";

    }

    private String extractID(){

        return "";

    }

    private String extractEmail(){

        return "";
    }


    public void setFileDetails(){
        this.studentName = extractName();
        this.studentID = extractID();
        this.studentEmail = extractEmail();
        this.studentIdentifier = extractIdentifier();
    }



    public String toString(){
        String output = "FileName: "+fName+"\nDelimited:";
        output = output+ (Arrays.toString(fNameDelimited))+"\n\n";
        return output;
    }


}
