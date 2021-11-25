package refactor.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class NestedFolder extends FileFixingDialog {

    private File folder;
    private File nestedFolder;


    public NestedFolder(Path path) {
        createNestedFolder(path);
    }

    public void createNestedFolder(Path path) {
        folder = new File(path.toString());
        String seperator = System.getProperty("file.separator");
        nestedFolder = new File(folder + seperator + "renamedFiles");

        if (folder.exists() && !nestedFolder.exists()) {
            nestedFolder.mkdir();// to create a folder/directory
            System.out.println("Nested folder created");
        }
    }

    public void copyFile(File newFile) throws IOException {
        String seperator = System.getProperty("file.separator");
        String path = "code"+seperator+"FilesToRename"+seperator+"renamedFiles"+seperator;
        if (!newFile.isDirectory()) {
            Files.copy(newFile.toPath(),
                    (new File(path + newFile.getName())).toPath());
        }
    }

    public Path getNestedFolderPath() {
        return nestedFolder.toPath();
    }

}