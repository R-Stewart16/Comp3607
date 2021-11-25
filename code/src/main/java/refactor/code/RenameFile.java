package refactor.code;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class RenameFile extends FileFixingDialog {
    
    String fileName; /*** the original file name of the submitted file */
    Path path;  /*** the path to the folder - FilesToRename  */

    /**
     * 
     * @param pathToFolder the path to the folder - FilesToRename 
     */
    public RenameFile(Path pathToFolder) {
        this.path = pathToFolder;
    }

    /**
     * Generates a new name to rename files based on convention 2
     * @param studentNames  the names of the student
     * @param participantID  the participant Id of the student
     * @param fileName  the original name of the file to be renamed 
     * @return  a string containing the new name to rename the file
     */
    public String generateNewName(ArrayList<String> studentNames, String participantID, String fileName) {
        String renamedFileName = new String();
        for (String s : studentNames) {
            renamedFileName += s + " ";
        }
        renamedFileName = renamedFileName.trim();
        renamedFileName += "_" + participantID + "_";
        renamedFileName += "assignsubmission_file_";
        renamedFileName += fileName;

        return renamedFileName;
    }


    /**
     * Renames the file to convention 2 by calling generateNewName
     * @param studentNames the names of the student
     * @param participantID the participant Id of the student
     * @param fileName the original name of the file to be renamed 
     * @throws InterruptedException  when the thread is awaken or interupted while it is sleeping/waitiing
     */
    public void changeFileName(ArrayList<String> studentNames, String participantID, String fileName)
            throws InterruptedException {

        String separator = System.getProperty("file.separator");
        String newName = generateNewName(studentNames, participantID, fileName);

        File nestedfolder = new File(path.toString());
        for (File file : nestedfolder.listFiles()) {
            if (file.getName().equals(fileName)) {

                File namingConvention2 = new File(nestedfolder + separator + newName);
                if (file.renameTo(namingConvention2))
                    System.out.println("File was renamed successfully");
                else
                    System.out.println("Failed to rename");

            }
        }
    }

}