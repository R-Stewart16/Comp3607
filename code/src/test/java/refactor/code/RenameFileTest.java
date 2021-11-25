package refactor.code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.*;

/**
 * Unit test for RenameFile.java class.
 */
public class RenameFileTest {
    private RenameFile renamedFile;
    Path pathToFolder;
    ArrayList<String> studentNames;
    String participantID = "601683";
    String fileName = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";

    public RenameFileTest() {
    }

    @BeforeEach
    public void setUp() {
        studentNames = new ArrayList<>();
        studentNames.add("Beth Morales-Horton");
        renamedFile = new RenameFile(pathToFolder);
    }

    @Test
    public void generateNewNameTest() {
        System.out.println("generateNewName()");
        String expected = "Beth Morales-Horton_601683_assignsubmission_file_1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";
        String actual = renamedFile.generateNewName(studentNames, participantID, fileName);
        assertEquals(expected, actual);
    }

}
