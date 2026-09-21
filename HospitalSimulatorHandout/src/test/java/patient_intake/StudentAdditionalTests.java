package patient_intake;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


  // The six unique tests for the patient system marked via @Test

public class StudentAdditionalTests {

    private PatientRegistry registry;
    
    @Test
    void testEmptyRegistryToStringDoesNotCrash() {
        // toString() on empty registry returns valid string without null pointer exception
        // Prevents crashes when displaying registry before adding patients
        registry = new PatientRegistry();
        String result = registry.toString();
        assertNotNull(result, "toString should not return null");
    }

    @Test
    void testFindNonExistentPatientReturnsNull() {
        // getPatientByID returns null for ID that doesn't exist
        // WSafe handling of queries caller checks null before using patient data
        registry = new PatientRegistry();
        Patient found = registry.getPatientByID("INVALID_ID");
        assertNull(found, "Should return null when patient not found");
    }
        
    @Test
    void testFindExistingPatientReturnsCorrectInstance() {
        // getPatientByID returns the correct patient when ID exists
        // Ensures lookup works correctly for valid patient IDs
        registry = new PatientRegistry();
        Patient p1 = new Patient("P001", "John", "Doe", 25, "Fever", 1, "Waiting", "Room1", 8, "INS001");
        registry.addPatient(p1);

        Patient found = registry.getPatientByID("P001");
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
    }

    @Test
    void testRegistryStoresMultiplePatientsInOrder() {
        // Multiple patients are stored and retrievable in correct order
        // Verifies array-based storage maintains insertion order
        registry = new PatientRegistry();

        Patient p1 = new Patient("P001", "Alice", "Brown", 30, "Headache", 2, "Waiting", "Room10", 9, "INS101");
        Patient p2 = new Patient("P002", "Bob", "Green", 45, "Chest pain", 3, "Waiting", "Room11", 10, "INS102");

        registry.addPatient(p1);
        registry.addPatient(p2);

        Patient[] patients = registry.getPatientRegistry();
        assertEquals(2, patients.length);
        assertEquals("Alice", patients[0].getFirstName());
        assertEquals("Bob", patients[1].getFirstName());
    }

    @Test
    void testToStringContainsClassInfo() {
        // toString() method includes registry information 
        // Useful for debugging 
        registry = new PatientRegistry();
        String result = registry.toString();
        assertTrue(result.contains("PatientRegistry"), "toString should identify class type");
    }

    @Test
    void testPatientDataRetainsValuesAfterAdd() {
        // Patient data remains intact after adding to registry
        // Ensures no accidental modification of patient fields during registry operations
        registry = new PatientRegistry();

        Patient original = new Patient("P010", "Original", "Name", 35, "Initial complaint", 4, "Waiting", "Room20", 11, "INS500");
        registry.addPatient(original);

        Patient retrieved = registry.getPatientByID("P010");
        assertEquals("Original", retrieved.getFirstName());
        assertEquals(35, retrieved.getAge());
        assertEquals("Initial complaint", retrieved.getChiefComplaint());
    }

    @Test
    void testAddTwoDifferentPatientsToRegistry() {
        // Registry can hold multiple patients with different IDs and data
        // Verifies that adding a second patient doesn't overwrite the first
        registry = new PatientRegistry();

        Patient p1 = new Patient("P001", "Alice", "Brown", 30, "Fever", 1, "Waiting", "Room10", 8, "INS001");
        Patient p2 = new Patient("P002", "Bob", "Green", 45, "Headache", 2, "Waiting", "Room11", 9, "INS002");
        
        registry.addPatient(p1);
        registry.addPatient(p2);
        
        // Both patients should still exist after adding second one
        Patient[] patients = registry.getPatientRegistry();
        assertEquals(2, patients.length);
        assertEquals("Alice", patients[0].getFirstName());
        assertEquals("Bob", patients[1].getFirstName());
    }
}
