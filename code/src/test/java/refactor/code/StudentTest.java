package refactor.code;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
    private String[] studentNames = { "BethMorales-Horton" };

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
        beth = new Student("602637", "81305512", studentNames, "beth.moraleshorton@my.uwi.edu");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testgetPartipantID() {
        System.out.println("getPartipantID()");
        String expResult = "602637";
        String result = beth.getParticipantID();
        assertEquals(expResult, result);
    }

    @Test
    public void testgetStudentID() {
        System.out.println("getStudentID()");
        String expResult = "81305512";
        String result = beth.getStudentID();
        assertEquals(expResult, result);
    }

    // @Test
    // public void testgetNames() {
    // System.out.println("getNames()");
    // String expResult = "BethMorale";
    // ArrayList<String> result = beth.getNames();
    // assertEquals(expResult, result);
    // }

    @Test
    public void testgetEmailAddress() {
        System.out.println("getEmailAddress()");
        String expResult = "beth.moraleshorton@my.uwi.edu";
        String result = beth.getEmailAddress();
        assertEquals(expResult, result);
    }

    @Test
    public void testgetAssignmentFileName() {
        System.out.println("getAssignmentFileName()");
        String result = beth.getParticipantID();
        assertNotNull(result);
    }

}
