package refactor.code;

import java.util.*;

public class RenameFile extends FileFixingDialog{
    String renamedFile = new String();

    public RenameFile(Student student) {
        renameFile(student);
    }

    /**
     * @param folderDir 
     * @param asg
     */
    
     /*
    public void Rename(String folderDir, AssignmentFile asg) {
        String renamedFileName = new String();
    }
    */

    public void renameFile(Student student){
        String[] studentNames = student.getNamesArr();
        String originalFileName = student.getAssignmentFileName();
        String renamedFileName = new String();

        for(int i = 0; i<studentNames.length; i++){
            renamedFileName += studentNames[i];
        }
        renamedFileName = renamedFileName.trim();
        renamedFileName += "_"+student.getParticipantID()+"_";
        renamedFileName += "assignsubmission_file_";
        renamedFileName += originalFileName;

        if(originalFileName.endsWith(".pdf")){
            renamedFileName+=".pdf";
        }
        
        if(originalFileName.endsWith(".docx")){
            renamedFileName+=".docx";
        }
        
        this.renamedFile = renamedFileName;
    }

    public String getRenamedFileName(){
        return renamedFile;
    }

}