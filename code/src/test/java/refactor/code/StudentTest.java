package refactor.code;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

// import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach; //previously After
import org.junit.jupiter.api.AfterAll; //previously AfterClass
import org.junit.jupiter.api.BeforeEach; //previously Before
import org.junit.jupiter.api.BeforeAll; //previously BeforeClass in Junit4
import org.junit.jupiter.api.Test;

/***
 * Unit test for Student.java class.
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
        String expected = "602637";
        String actual = beth.getParticipantID();
        assertEquals(expected, actual);
    }

    @Test
    public void testgetStudentID() {
        System.out.println("getStudentID()");
        String expected = "81305512";
        String actual = beth.getStudentID();
        assertEquals(expected, actual);
    }

    @Test
    public void testgetNames() {
        System.out.println("getNames()");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("BethMorales-Horton");
        ArrayList<String> actual = beth.getNames();
        assertEquals(expected, actual);
    }

    @Test
    public void testgetEmailAddress() {
        System.out.println("getEmailAddress()");
        String expected = "beth.moraleshorton@my.uwi.edu";
        String actual = beth.getEmailAddress();
        assertEquals(expected, actual);
    }

    @Test
    public void testgetAssignmentFileName() {
        System.out.println("getAssignmentFileName()");
        String actual = beth.getParticipantID();
        assertNotNull(actual);
    }

}
