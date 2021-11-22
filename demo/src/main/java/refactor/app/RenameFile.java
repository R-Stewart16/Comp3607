package refactor.app;

import java.util.*;

public class RenameFile {

    public RenameFile() {
    }

    /**
     * @param folderDir 
     * @param asg
     */
    public void Rename(String folderDir, AssignmentFile asg) {
        String renamedFileName = new String();
    }

    public void renameFile(Student student){
        String renamedFileName = new String();
        String originalFileName = student.studentSubmission.getFileName;

        for(int i = 0; i<student.studentNames.length; i++){
            renamedFileName += studentNames[i];
        }
        renamedFileName = renamedFileName.trim();
        renamedFileName += "_"+student.getParticipantID+"_";
        renamedFileName += "assignsubmission_file_";
        renamedFileName += originalFileName;

        if(originalFileName.endsWith(".pdf")){
            renamedFileName+=".pdf";
        }
        
        if(originalFileName.endsWith(".docx")){
            renamedFileName+=".docx";
        }

    }



}