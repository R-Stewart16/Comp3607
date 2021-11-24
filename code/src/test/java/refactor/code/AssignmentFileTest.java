package refactor.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for AssignmentFile.java class.
 */
public class AssignmentFileTest {
    private AssignmentFile file;

    public AssignmentFileTest() {
    }

    @BeforeEach
    public void setUp() {
        file = new AssignmentFile("1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512");
    }

    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        String expected = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512";
        String actual = file.getFileName();
        assertEquals(expected, actual);
    }

}