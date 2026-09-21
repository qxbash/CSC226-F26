package triage_efficiency;

import java.util.*; 
import patient_intake.Patient;

public class EfficiencyTester {

    /**
     * REQUIRED (80%): Implement linear search.
     *
     * Search through the patient array one element at a time until the matching
     * patientID is found. Return the Patient if it exists; otherwise return null.
     *
     * This method must run in O(n) time. "checking one by one"
     */
    public Patient linearSearch(Patient[] patients, String pid) {
        for (int i =0; i < patients.length; i ++) { 

            if (patients[i].getPatientID().equals(pid)) { // .equals is needed for strings
                
                return patients[i];
            }
        // COMPLETED: Implemented linear search.
        // Search the entire array in order and return the matching Patient.
        }
        return null;
    }
        
    /**
     * REQUIRED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time. "cutting in half each time"
     */
    public Patient binarySearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement iterative binary search.
        // The array must be sorted by patientID before calling this method.
        int lowest = 0; // Starts at first index 
        int highest = patients.length; // the latest valid index

        while (lowest <= highest) {
            int middle = (lowest + highest) / 2;

            String middlePatientID = patients[middle].getPatientID(); 

        }
         return null; // PLACEHOLDER!: not finished with binary search method yet! 

    }

    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     *
     * Pick one of the following approaches and implement it:
     * - Exponential search  
     * - Jump search
     * - Ternary search
     *
     * Add a short comment above the method explaining:
     * - which algorithm you chose
     * - where you learned about it
     * - why it works
     */
    public Patient logNSearch(Patient[] patients, String pid) {
        // TODO OPTIONAL: Research and implement a second O(log n) algorithm.
        // Cite your source and explain the approach in a comment before the logic.
        return null; // Remove this line and implement the method.
    }

    public void timeDemo() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 + 5;
        }
        long endTime = System.nanoTime();

        System.out.println("The example addition took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 * 5;
        }
        endTime = System.nanoTime();
        System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    }
}
