package refactor.code;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

// import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach; //previously After
import org.junit.jupiter.api.AfterAll; //previously AfterClass
import org.junit.jupiter.api.BeforeEach; //previously Before
import org.junit.jupiter.api.BeforeAll; //previously BeforeClass in Junit4
import org.junit.jupiter.api.Test;

/**
 * Unit test for Student.java class.
 */
public class GodObjectTest {
    private Student student;
    private String[] studentNames = { "BethMorales-Horton" };
    private MatchStudentsToAssignment matchingComponent;
    private ArrayList<String> idMarkers;

    private AssignmentFile newAssignmentFile;

    public GodObjectTest() {

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        student = new Student("602637", "81305512", studentNames, "beth.moraleshorton@my.uwi.edu");
        matchingComponent = new MatchStudentsToAssignment();
        idMarkers = new ArrayList<String>();
        idMarkers.add(student.getParticipantID());
        idMarkers.add(student.getStudentID());
        idMarkers.add(student.getEmailAddress());
        newAssignmentFile = new AssignmentFile("1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf");
    }

    @Test
    public void matchStudentsTest() {
        System.out.println("matchStudents()");
        boolean success = false;
        if (matchingComponent.match(idMarkers, newAssignmentFile.getDelimited(),
                "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf"))
            success = true;

        assertTrue(success);
    }

    // @Test
    // public void testgetStudentID() {
    // System.out.println("getStudentID()");
    // String expected = "81305512";
    // String actual = beth.getStudentID();
    // assertEquals(expected, actual);
    // }

    // @Test
    // public void testgetEmailAddress() {
    // System.out.println("getEmailAddress()");
    // String expected = "beth.moraleshorton@my.uwi.edu";
    // String actual = beth.getEmailAddress();
    // assertEquals(expected, actual);
    // }

    // @Test
    // public void testgetAssignmentFileName() {
    // System.out.println("getAssignmentFileName()");
    // String actual = beth.getParticipantID();
    // assertNotNull(actual);
    // }

}
