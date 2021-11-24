package refactor.code;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.*;

public class RenameFileTest {

    private RenameFile renamedFile;
    Path pathToFolder;
    ArrayList<String> studentNames = new ArrayList<>();
    String participantID = "602637";
    String fileName = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";

    public RenameFileTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    // @AfterAll
    // public static void tearDownClass() {
    // File f = new File("renamedFiles");
    // f.delete();
    // }

    @BeforeEach
    public void setUp() {
        // File f = new File("renamedFiles");
        // f.mkdir();
        studentNames.add("BethMorale");
        renamedFile = new RenameFile(pathToFolder);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void generateNewNameTest() {
        System.out.println("getgeneratedFile");
        String results = renamedFile.generateNewName(studentNames, participantID, fileName);
        // assertNotNull(results);
    }

    @Test
    public void changeFileNameTest() {
        System.out.println("changefilename");
        // assertEquals("", renamedFile.changeFileName(studentNames, participantID,
        // fileName));
    }

}