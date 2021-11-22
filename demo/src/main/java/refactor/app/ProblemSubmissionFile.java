package refactor.app;


import java.util.*;

public class ProblemSubmissionFile {
    
    public ArrayList<String> problemFiles;

    public ProblemSubmissionFile() {
    }

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

}