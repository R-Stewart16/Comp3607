package refactor.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.DisplayName;

/**
 * Unit test for simple App.
 */
public class AssignmentFileTest {
    private AssignmentFile file;

    public AssignmentFileTest() {
    }

    // This method runs before each test method
    // can renamed to initialiseLecturerObjects
    @BeforeEach
    public void setUp() {
        file = new AssignmentFile("1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512");
    }

    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        String expected = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512";
        String result = file.getFileName();
        assertEquals(expected, result);
    }

}