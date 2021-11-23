package refactor.code;

import java.util.*;

public class ProblemSubmissionFile extends FileFixingDialog{        //missing submissions?
    
    //public ArrayList<String> problemFiles;
    private ArrayList<String> missingSubmissions;

    private ArrayList<Student> students = getStudents();

    public ProblemSubmissionFile() {
        storeMissingSubmissions();
    }

    private void storeMissingSubmissions(){
        String missingSubmissionTxt = new String();
        for(Student temp : students){
            if(!temp.getSubmissionState()){
                missingSubmissionTxt += "Student Name: "+ temp.getNames().toString() + ".\n";
                missingSubmissionTxt += "Student ID: "+temp.getStudentID();
            }
            missingSubmissions.add(missingSubmissionTxt);
        }
    }

    public ArrayList<String> getMissingSubmissions(){
        return missingSubmissions;
    }


/*
    public void addSubmission(String problemFile) {
        problemFiles.add(problemFile);
    }

    public String toString() {
        String details = "";
        for (String s: problemFiles){
            details += s.toString();
        }
        return details;
    }
*/

}