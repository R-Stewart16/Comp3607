package refactor.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CopyFile extends FileFixingDialog{

    public CopyFile() {
        
    }

    public void createNestedFolder() {
        final File folder = new File("FilesToRename");
        File nestedFolder = new File(folder + "/renamedFiles");

        if (folder.exists()) {
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Folder created");
        }
    }

    public static void copyFiles(File nestedFolder, File folder) throws IOException {
        String path = "oopproject/FilesToRename/renamedFiles/";
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".pdf")) {
                // copy files from folder to nestedFolder
                Files.copy(file.toPath(), (new File(path + file.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

}