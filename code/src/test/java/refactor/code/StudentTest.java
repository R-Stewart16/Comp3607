package refactor.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach; //previously After
import org.junit.jupiter.api.AfterAll; //previously AfterClass
import org.junit.jupiter.api.BeforeEach; //previously Before
import org.junit.jupiter.api.BeforeAll; //previously BeforeClass in Junit4
import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.DisplayName;
//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class StudentTest {
    private Student beth;

    public StudentTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    // This method runs before each test method
    // can renamed to initialiseLecturerObjects
    @BeforeEach
    public void setUp() {
        beth = new Student("602637", "81305512", "BethMorales-Horton", "beth.moraleshorton@my.uwi.edu");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getFirstName method, of class Student.@DisplayName("😱 emoji name")
     */

    @Test
    public void testgetPartipantID() {
        System.out.println("getPartipantID");
        String expResult = "602637";
        String result = beth.getParticipantID();
        assertEquals(expResult, result);
    }

}
