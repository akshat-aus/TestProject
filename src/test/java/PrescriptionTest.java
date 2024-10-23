import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrescriptionTest {

    // Test addPrescription method with valid data
    @Test
    public void testAddValidPrescription() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertTrue(presc.addPrescription());
    }

    // Test addPrescription with invalid first name
    @Test
    public void testAddInvalidFirstName() {
        Prescription presc = new Prescription("Jo", "Doe", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertFalse(presc.addPrescription());
    }

    // Test addPrescription with invalid last name
    @Test
    public void testAddInvalidLastName() {
        Prescription presc = new Prescription("John", "Do", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertFalse(presc.addPrescription());
    }

    // Test addPrescription with invalid address length
    @Test
    public void testAddInvalidAddress() {
        Prescription presc = new Prescription("John", "Smith", "Short address", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertFalse(presc.addPrescription());
    }

    // Test addPrescription with invalid sphere
    @Test
    public void testAddInvalidSphere() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 21.0, -1.0, 90, "12/12/23", "Dr. Smith");
        assertFalse(presc.addPrescription());
    }

    // Test addPrescription with invalid optometrist name length
    @Test
    public void testAddInvalidOptometristName() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Doc");
        assertFalse(presc.addPrescription());
    }

    // Test addRemark method with valid remark
    @Test
    public void testAddValidRemark() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertTrue(presc.addRemark("This is a valid remark with more than six words.", "client"));
    }

    // Test addRemark with remark that is too short
    @Test
    public void testAddInvalidRemarkTooShort() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertFalse(presc.addRemark("Short remark.", "client"));
    }

    // Test addRemark with more than two remarks
    @Test
    public void testAddMoreThanTwoRemarks() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        presc.addRemark("This is the first valid remark.", "client");
        presc.addRemark("This is the second valid remark.", "optometrist");
        assertFalse(presc.addRemark("This is the third valid remark.", "client"));
    }

    // Test addRemark with invalid category
    @Test
    public void testAddInvalidCategory() {
        Prescription presc = new Prescription("John", "Smith", "1234 Elm Street, Springfield, USA", 1.5, -1.0, 90, "12/12/23", "Dr. Smith");
        assertFalse(presc.addRemark("This is a valid remark with a bad category.", "doctor"));
    }
}
