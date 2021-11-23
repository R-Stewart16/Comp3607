package refactor.code;

import org.junit.jupiter.api.AfterEach; //previously After
import org.junit.jupiter.api.AfterAll; //previously AfterClass
import org.junit.jupiter.api.BeforeEach; //previously Before
import org.junit.jupiter.api.BeforeAll; //previously BeforeClass in Junit4
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
    @BeforeAll
    public void setUp() {
        file = new AssignmentFile("Beth Morales-Horton_601683_assignsubmission_file_Assignment1_81305512.pdf");
    }

    @AfterAll
    public void tearDown() {
    }

    /**
     * Test of getFirstName method, of class Student.@DisplayName("😱 emoji name")
     */

    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        String expected = file.getFileName();
        String result = "Beth Morales-Horton_601683_assignsubmission_file_Assignment1_81305512.pdf";
        assertEquals(expected, result);
    }

}
