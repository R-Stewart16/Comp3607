package refactor.code;

import java.util.*;

public class MatchStudentsToAssignment {

    public MatchStudentsToAssignment(ArrayList<Student> students, ArrayList<AssignmentFile> asg) {
        match(students, asg);
    }

    private boolean nameSearch(String fileName, String[] studentName){
        for(int i = 0; i<studentName.length; i++){
            if(fileName.contains(studentName[i]) && fileName.contains(studentName[i+1])){      //if student name is in file name then found //might get npe
                return true;
            }
        }
        return false;
    }

    public void match(ArrayList<Student> students, ArrayList<AssignmentFile> asg) {
        String[] delimitedFileName;

        for(AssignmentFile temp: asg){
            delimitedFileName = temp.getDelimited();

            for(int i = 0; i<delimitedFileName.length; i++){
                
                for(Student tempStudent: students){
                    if( delimitedFileName[i].equals(tempStudent.getParticipantID()) || delimitedFileName[i].equals(tempStudent.getEmailAddress()) ||
                        delimitedFileName[i].equals(tempStudent.getStudentID())  || nameSearch(delimitedFileName[i], tempStudent.getNamesArr()) ){
                            //student found i.e. matched student to file.
                            //add curr asg to curr student in filefixing dialog
                    } 
                }
            }
        }
    }
}