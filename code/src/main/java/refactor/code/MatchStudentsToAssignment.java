package refactor.code;

import java.util.*;

public class MatchStudentsToAssignment {

    public MatchStudentsToAssignment() {
    }

    private boolean nameSearch(String fileName, String[] studentName){
        for(int i = 0; i<studentName.length; i++){
            if(fileName.contains(studentName[i]) && fileName.contains(studentName[i+1])){      //if student name is in file name then found //might get npe
                return true;
            }
        }
        return false;
    }

    public boolean match(ArrayList<String> studentIdentificationMarkers, String[] asgFileName) {
        
        String[] delimitedFileName;
            delimitedFileName = asgFileName;

            for(int i = 0; i<delimitedFileName.length; i++){
                
                for(String id: studentIdentificationMarkers){
                    if( delimitedFileName[i].equals(id) || delimitedFileName[i].equals(id) ||
                        delimitedFileName[i].equals(id) /*|| nameSearch(delimitedFileName[i], id)*/ ){
                            //student found i.e. matched student to file.
                            //add curr asg to curr student in filefixing dialog
                            return true;
                    } 
                }
            }
        return false;
    }


}