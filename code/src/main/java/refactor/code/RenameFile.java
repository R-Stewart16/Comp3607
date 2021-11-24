package refactor.code;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class RenameFile extends FileFixingDialog {

    String fileName;
    Path path;

    public RenameFile(Path pathToFolder) {
        this.path = pathToFolder;
    }

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