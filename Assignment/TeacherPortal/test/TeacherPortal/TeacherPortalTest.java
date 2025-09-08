package TeacherPortal;

import TeacherPortal.Student_Information;
import TeacherPortal.TeacherPortal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherPortalTest {

    @Before
    public void setup() {
        // Clear existing students before each test
        TeacherPortal.studentInformation.clear();

        // Add a test student
        Student_Information s1 = new Student_Information();
        s1.setStudentName("John");
        s1.setStudentSurname("Doe");
        s1.setStudentNumber(123456);
        s1.setAFR(80);
        s1.setBS(90);
        s1.setCS(85);
        s1.setENG(70);
        s1.setLO(75);
        s1.setLS(95);
        s1.setMATHS(100);
        s1.setAVG();
        TeacherPortal.studentInformation.add(s1);

        // Add another student
        Student_Information s2 = new Student_Information();
        s2.setStudentName("Jane");
        s2.setStudentSurname("Smith");
        s2.setStudentNumber(654321);
        s2.setAFR(60);
        s2.setBS(65);
        s2.setCS(70);
        s2.setENG(75);
        s2.setLO(80);
        s2.setLS(85);
        s2.setMATHS(90);
        s2.setAVG();
        TeacherPortal.studentInformation.add(s2);
    }

    @Test
    public void testSearchLearnerFound() {
        boolean found = false;
        String fullname = "John Doe";

        for (Student_Information si : TeacherPortal.studentInformation) {
            String studentName = si.getStudentName() + " " + si.getStudentSurname();
            if (studentName.equals(fullname)) {
                found = true;
                assertEquals(123456, si.getStudentNumber());
                assertEquals(80, si.getAFR());
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSearchStudentNumberFound() {
        int studentID = 654321;
        boolean found = false;

        for (Student_Information si : TeacherPortal.studentInformation) {
            if (si.getStudentNumber() == studentID) {
                found = true;
                assertEquals("Jane", si.getStudentName());
                assertEquals("Smith", si.getStudentSurname());
            }
        }

        assertTrue(found);
    }

    @Test
    public void testTopAchiever() {
        Student_Information top = TeacherPortal.studentInformation.get(0);
        for (Student_Information s : TeacherPortal.studentInformation) {
            if (s.getAVG() > top.getAVG()) {
                top = s;
            }
        }
        assertEquals("John", top.getStudentName());
        assertEquals("Doe", top.getStudentSurname());
    }

    @Test
    public void testUpdateMarks() {
        for (Student_Information s : TeacherPortal.studentInformation) {
            if (s.getStudentName().equals("Jane")) {
                s.setAFR(90);
                s.setAVG();
            }
        }
        for (Student_Information s : TeacherPortal.studentInformation) {
            if (s.getStudentName().equals("Jane")) {
                assertEquals(90, s.getAFR());
            }
        }
    }
}
