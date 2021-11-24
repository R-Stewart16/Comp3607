package refactor.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    public void changeFileName(ArrayList<String> studentNames, String participantID,String fileName) throws InterruptedException{

        String separator = System.getProperty("file.separator");
        String newName = generateNewName(studentNames, participantID, fileName);
        String source = path.toString()+separator+fileName;

        File nestedfolder = new File(path.toString());
        for (File file: nestedfolder.listFiles()){
            if (file.getName().equals(fileName)){
                System.out.println("Renamed folder content :"+ fileName);
                System.out.println(path.toString()+separator+fileName);

                // File namingConvention2 = new File(nestedfolder + separator + newName);
                // //Thread.sleep(2000);
                // if(file.renameTo(namingConvention2))
                //     System.out.println("File was renamed successfully");
                // else 
                //     System.out.println("Failed to rename");
                 try {
                    Files.move(Paths.get(source), Paths.get("code").resolveSibling(newName));
                    System.out.println("File Successfully Rename");
                }
                catch (IOException e) {
                    System.out.println("operation failed");
                }
            }
        } 
    }

    public static void main(String[] args) {
        Integer i = 1;
        File nestedfolder = new File("code/FilesToRename/renamedFiles");
        for (File file: nestedfolder.listFiles()){
                System.out.println("Renamed folder content :"+ file.getName());

                File namingConvention2 = new File(nestedfolder + "/" + i.toString() +".pdf");
                i++;

                if(file.renameTo(namingConvention2))
                    System.out.println("File was renamed successfully");
                else 
                    System.out.println("Failed to rename");
        }
    }

}