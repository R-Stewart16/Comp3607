package refactor.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class NestedFolder extends FileFixingDialog{

    private File folder;
    private File nestedFolder;


    public NestedFolder(Path path) {
        createNestedFolder(path);
    }

    public void createNestedFolder(Path path) {
        folder = new File(path.toString());
        nestedFolder = new File(folder + "/renamedFiles");

        if (folder.exists() && !nestedFolder.exists()) {
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }
    }

    public void copyFiles(File folder) throws IOException {
        String path = "code/FilesToRename/renamedFiles/";
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".pdf")) {
                // copy files from folder to nestedFolder
                Files.copy(file.toPath(), (new File(path + file.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    public Path getNestedFolderPath(){
        return nestedFolder.toPath();
    }
    
}