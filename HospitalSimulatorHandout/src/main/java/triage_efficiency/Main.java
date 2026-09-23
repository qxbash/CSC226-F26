package triage_efficiency;

import patient_intake.Patient;
import java.util.Arrays; // Array tools
import java.util.Comparator; // tools in order to utilize a sort order

public class Main {
    // Tester instance for search operations:
    private static final EfficiencyTester tester = new EfficiencyTester();

    public static void main(String[] args) {
        // Generates patient data (create 6 patients for testing)
        Patient[] patients = generatePatients(6);

        System.out.println("=== Generated Patients ===");
        for (Patient p : patients) {
            System.out.println(p.getPatientID() + " - " + p.getFirstName()
            + " " + p.getLastName());
        }

        // Sort by patientID for binary search testing
        Patient[] sortedPatients = sortByPatientId(patients);

        System.out.println("\n=== Sorted Patients (by ID) ===");
        for (Patient p : sortedPatients) {
            System.out.println(p.getPatientID());
        }

        // Test Linear Search - FOUND example
        System.out.println("\n=== Testing Linear Search ===");
        Patient found1 = tester.linearSearch(sortedPatients, "P00003");
        if (found1 != null) {
            System.out.println("Linear search found patient P00003");
        } else {
            System.out.println("NOT FOUND: P99999");
        }

        // Test Linear Search - NOT FOUND example
        Patient notFound1 = tester.linearSearch(sortedPatients, "P99999");
        if (notFound1 != null) {
            System.out.println("Linear search found patient " + notFound1.getPatientID());
        } else {
            System.out.println("NOT FOUND: P99999");
        }

        // Test Binary Search - FOUND example
        System.out.println("\n=== Testing Binary Search ===");
        Patient found2 = tester.binarySearch(sortedPatients, "P00005");
        if (found2 != null) {
            System.out.println("Binary search found patient P00005");
        } else {
            System.out.println("NOT FOUND: P99999");
        }

        // Test Binary Search - NOT FOUND example
        Patient notFound2 = tester.binarySearch(sortedPatients, "P10000");
        if (notFound2 != null) {
            System.out.println("Binary search found patient " + notFound2.getPatientID());
        } else {
            System.out.println("NOT FOUND: P10000");
        }

    }

    /**
     * REQUIRED (80%): Generate sample patient data for testing.
     *
     * Build an array of Patient objects with realistic IDs, names, complaints,
     * and triage information so you can test each search method. 
     */
    public static Patient[] generatePatients(int count) {
        // COMPLETED: Create the patient array and fill it with sample data.
        Patient[] patients = new Patient[count]; //initializes patient array

        // My list of sample patients 
        String[] firstNames = {"John", "Jane", "Bob", "Alice", "Mike", "Kate"};
        String[] lastNames = {"Smith", "Woods", "Brown", "Miller", "Davis", "Brooks"};
        String[] complaints = {"Dizziness", "Nausea", "Broken Leg", "Difficulty Breathing", "Fatigue"};
        
        for (int i = 0; i < count; i++) {
            String id = "P" + String.format("%05d", i + 1); // Assigns ID with preceding 5 ints

            // Use modulo to wrap around if complaint array is shorter than count
            String complaint = complaints[i % complaints.length];

            patients[i] = new Patient(
                id,                                         // patient's ID
                firstNames[i],                              
                lastNames[i],          
                20,                                        // age
                complaint,                                  // chiefComplaint
                1,                                          // Triage Level (1-5)
                "Pending",                                  // currentStage
                "ER-ROOM" + String.format("%03d", i + 1),   // assignedRoom
                8,                                          // arrivalHour
                "INS-" + String.format("%05d", i + 1)      // insuranceID
            );      
        }
        return patients;
    }

    /**
     * REQUIRED (80%): Sort patients by patientID before binary search.
     *
     * The binary-search version only works on an array sorted by patientID.
     */
    public static Patient[] sortByPatientId(Patient[] patients) {
        // Use Arrays.sort with Comparator to sort by patientID field
        Arrays.sort(patients, Comparator.comparing(Patient::getPatientID));

        return patients;
    }
}

