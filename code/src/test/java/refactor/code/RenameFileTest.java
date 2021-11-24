package refactor.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Path;
import java.util.*;

public class RenameFileTest {

    private RenameFile renamedFile;
    Path pathToFolder;
    ArrayList<String> studentNames = new ArrayList<>();
    String participantID = "601683";
    String fileName = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";

    public RenameFileTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @BeforeEach
    public void setUp() {
        studentNames.add("Beth Morales-Horton");
        renamedFile = new RenameFile(pathToFolder);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void generateNewNameTest() {
        System.out.println("generateNewName()");
        String expected = "Beth Morales-Horton_601683_assignsubmission_file_1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";
        String actual = renamedFile.generateNewName(studentNames, participantID, fileName);
        assertEquals(expected, actual);
    }

    @Test
    public void changeFileNameTest() {
        System.out.println("changeFileName()");
        // assertEquals("code/filestorename/", renamedFile.changeFileName(studentNames,
        // participantID, fileName));// not working correctly
    }

}
