package refactor.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateRenamedFileTest {
    private NestedFolder renamedFiles;
    String separator = System.getProperty("file.separator");
    Path pathToFolder;

    public CreateRenamedFileTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @BeforeEach
    public void setUp() {
        Path pathToFolder = Paths.get("code" + separator + "FilesToRename" + separator).toAbsolutePath();
        renamedFiles = new NestedFolder(pathToFolder);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getNestedFolderPathTest() {
        System.out.println("getNestedFolderPath()");
        Path expected = Paths.get("code" + separator + "FilesToRename" + separator + "renamedFiles").toAbsolutePath();
        Path actual = renamedFiles.getNestedFolderPath();
        assertEquals(expected, actual);
    }
}
