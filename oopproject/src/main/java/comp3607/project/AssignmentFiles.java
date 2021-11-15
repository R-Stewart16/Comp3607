package comp3607.project;

import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentFiles {
    private String fName = new String();
    private String[] fNameDelimited;
    private ArrayList<Student> allStudents = new ArrayList<>();
    private App a = new App();

    private static int studentIndex;

    private ArrayList<String> studentName = new ArrayList<>();  //full Name 
    private String studentIdentifier = new String();
    private String studentID = new String();
    private String studentEmail = new String();

    public AssignmentFiles(String fileName){
        this.fName = fileName;
        splitFname();

        this.allStudents = a.getStudents();
        setFileDetails();
    }

    private void splitFname(){
        this.fNameDelimited = fName.split("[_ -.,\\s+]");       //https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
    }

    private void extract(){     

        for(Student temp: allStudents){
            for(int i=0; i<fNameDelimited.length; i++){
                //do something 
                if(fNameDelimited[i].equals(temp.getParticipantID()) || fNameDelimited[i].equals(temp.getEmailAddress()) ||
                    fNameDelimited[i].equals(temp.getStudentID())    /*|| fNameDelimited[i].equals(temp.getNames()) */ ) {
                    
                        this.studentIdentifier = temp.getParticipantID();
                        this.studentID = temp.getStudentID();
                        this.studentEmail = temp.getEmailAddress();
                        this.studentName = temp.getNames();
                }

            }

        }
    }

    /*
    private String extractName(){
        if(!extractIdentifier().equals("")){    //if identifier found go directly to other stuff //else search 
            
        }
        
        for(Student temp: allStudents){

            for(int i=0; i<fNameDelimited.length; i++){
                //do something 
            }

        }


        return "";
    }

    private String extractIdentifier(){
        String identifier;
        for(Student temp: allStudents){
            studentIndex++;
            for(int i=0; i<fNameDelimited.length; i++){
                //do something 
                if(fNameDelimited[i].equals(temp.getParticipantID())){
                    identifier = fNameDelimited[i];
                    return identifier;
                }
            }

        }

        return "";
    }

    private String extractID(){
        String studentID;
        for(Student temp: allStudents){

            for(int i=0; i<fNameDelimited.length; i++){
                //do something 
                if(fNameDelimited[i].equals(temp.getStudentID())){
                    studentID = fNameDelimited[i];
                    return studentID;
                }
            }

        }
        
        return "";
    }

    private String extractEmail(){
        String studentEmail;
        for(Student temp: allStudents){

            for(int i=0; i<fNameDelimited.length; i++){
                //do something 
                if(fNameDelimited[i].equals(temp.getEmailAddress())){
                    studentEmail = fNameDelimited[i];
                    return studentEmail;
                }
            }

        }
        return "";
    }
*/

    public void setFileDetails(){
        extract();
        //this.studentName = extractName();
        /*
        this.studentID = extractID();
        this.studentEmail = extractEmail();
        this.studentIdentifier = extractIdentifier();
        */
        
    }



    public String toString(){
        String output = "FileName: "+fName+"\nDelimited:";
        output = output+ (Arrays.toString(fNameDelimited))+"\n\n";
       
        output+="\tIdentifier: "+ studentIdentifier +"\n";
        output+="\tStudent Name: "+ (studentName.toString())  +"\n";
        output+="\tEmail Address: "+ studentEmail +"\n";
        output+="\tStudent ID: "+ studentID +"\n\n\n\n";
        
        /* 
        output+="Identifier: "+extractIdentifier()+"\n";
        output+="Email Address: "+extractEmail()+"\n";
        output+="Student ID: "+extractID()+"\n\n\n\n";
        */

        return output;
    }


}
