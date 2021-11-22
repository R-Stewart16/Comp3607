package refactor.app;

import java.util.*;

public class MatchStudentsToAssignment {

    public MatchStudentsToAssignment() {
    }


    /**
     * @param student 
     * @param asg
     */
    public void match(ArrayList<Student> students, ArrayList<AssignmentFile> asg) {
        String[] delimitedFileName;

        for(AssignmentFile temp: asg){
            delimitedFileName = temp.getDelimited();

            for(int i = 0; i<delimitedFileName.length; i++){
                
                for(Student tempStudent: students){
                    if(delimitedFileName[i].equals(tempStudent.getParticipantID()) || delimitedFileName[i].equals(tempStudent.getEmailAddress()) ||
                        delimitedFileName[i].equals(tempStudent.getStudentID())  /*|| name search here */){
                            //student found i.e. matched student to file.
                            //add curr asg to curr student in filefixing dialog
                        
                    
                    }
                    
                }


            }



        }

    }

}