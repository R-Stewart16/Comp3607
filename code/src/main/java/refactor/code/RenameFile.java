package refactor.code;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class RenameFile extends FileFixingDialog{
    
    String fileName;
    Path path;

    public RenameFile(Path pathToFolder) {
        this.path = pathToFolder;
    }

    /*
    public void Rename(String folderDir, AssignmentFile asg) {
        String renamedFileName = new String();
    }
    */

    public String generateNewName(ArrayList<String> studentNames, String participantID,String fileName){
        String renamedFileName = new String();
        //String[] studentNames = student.getNamesArr();
        //this.fileName = fileName;
        for(String s: studentNames){
            renamedFileName += s + " ";
        }
        renamedFileName = renamedFileName.trim();
        renamedFileName += "_"+participantID+"_";
        renamedFileName += "assignsubmission_file_";
        renamedFileName += fileName;

        // if(fileName.endsWith(".pdf")){
        //     renamedFileName+=".pdf";
        // }
        
        // if(fileName.endsWith(".docx")){
        //     renamedFileName+=".docx";
        // }
        renamedFileName+="\n";
        
        System.out.println();
        System.out.println(renamedFileName);
        System.out.println();
        return renamedFileName;
    }

    public void changeFileName(ArrayList<String> studentNames, String participantID,String fileName){

        String separator = System.getProperty("file.separator");

        File nestedfolder = new File(path.toString());
        for (File file: nestedfolder.listFiles()){
            if (file.getName().equals(fileName)){
                System.out.println("Renamed folder content :"+ fileName);
                System.out.println(nestedfolder + separator + generateNewName(studentNames, participantID, fileName));
                File namingConvention2 = new File(nestedfolder + separator + generateNewName(studentNames, participantID, fileName));
                if(file.renameTo(namingConvention2))
                    System.out.println("File was renamed successfully");
                else 
                    System.out.println("Failed to rename");
            }
        } 
    }

}