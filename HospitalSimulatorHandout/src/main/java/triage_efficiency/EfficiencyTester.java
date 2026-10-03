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
     * COMPLETED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time. "cutting in half each time"
     */
    public Patient binarySearch(Patient[] patients, String pid) {
        // COMPLETED: Implement iterative binary search.
        // The array must be sorted by patientID before calling this method.
        int lowest = 0; // starts at first index 
        int highest = patients.length - 1; // last valid index

        while (lowest <= highest) {
            int middle = (lowest + highest) / 2;

            String middlePatientID = patients[middle].getPatientID(); 

            // Compare the patient IDs
            if (middlePatientID.equals(pid)) { // <-- Paitient ID
                return patients[middle]; // Found! Return this patient.
            } else if (pid.compareTo(middlePatientID) < 0) {
                highest = middle - 1; // smaller, so it searches left half
            } else {
                lowest = middle + 1; // bigger, so it searches right half
            }
        }

        return null; // Not found after exhausting the search range
    }

    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     
     * Pick one of the following approaches and implement it:
     * Jump search
     * SOURCE: https://medium.com/@robinviktorsson/jump-search-algorithm-in-java-learn-with-practical-examples-633876051750
        (I reffered to this article for understanding the concept of jump search.)
     
        * Why does it work?:
        I chose jump search because it is practical for when an arrray cannot be accessed randomly. 
        It essentially acts as a modified linear search with jumping capabilities.

        * How it works:
            1) The algorithm will jump in fixed block sizes until the target is reached or overshot
            2) It will search backwards from that given point.
            
     */
    // The implementation of jump search:
    // public Patient logNSearch(Patient[] patients, String pid) {
    // if (patients.length == 0) {
    //     return null;
    // }

    // The math function to perform the square root
    // int jumpSize = (int) Math.sqrt(patients.length);

    // If array is small or jumpSize is 0 substitute binary search 
    // if (jumpSize <= 1) {
    //     return binarySearch(patients, pid);
    // }

    // int lowest = 0;

    // while (lowest < patients.length) {
    //     // jumps ahead
    //     int nextIndex = lowest + jumpSize;

    //     // check bounds
    //     if (nextIndex >= patients.length) {
    //         // Final linear search from current position to end
    //         for (int i = lowest; i < patients.length; i++) {
    //             if (patients[i].getPatientID().equals(pid)) {
    //                 return patients[i];
    //             }
    //         }
    //         break;
    //     }

    //     String nextPatientID = patients[nextIndex].getPatientID();

    //     // if target found
    //     if (nextPatientID.equals(pid)) {
    //         return patients[nextIndex];
    //     } 
    //     // Target is smaller, go left
    //     else if (pid.compareTo(nextPatientID) < 0) {
    //         lowest = nextIndex;
    //         nextIndex -= jumpSize;
            
    //         // Linear search backwards from current position
    //         while (nextIndex >= lowest && nextIndex > lowest - jumpSize) {
    //             if (patients[nextIndex].getPatientID().equals(pid)) {
    //                 return patients[nextIndex];
    //             }
    //             nextIndex--;
    //         }
    //         break; // Target not found 
    //     } 
    //     // keep jumping right if target is larger
    //     else {lowest = nextIndex;}
    // }
    // // check the last position if not returned 
    // if (lowest < patients.length && patients[lowest].getPatientID().equals(pid)) {
    //     return patients[lowest];
    // }

    // return null;
}
    // TimeDemo test case:
    // public void timeDemo() {
    //     long startTime = System.nanoTime();
    //     for (int i = 0; i < 100000; i++) {
    //         int x = 5 + 5;
    //     }
    //     long endTime = System.nanoTime();

    //     System.out.println("The example addition took: " + (endTime - startTime) + " ns");

    //     startTime = System.nanoTime();
    //     for (int i = 0; i < 100000; i++) {
    //         int x = 5 * 5;
    //     }
    //     endTime = System.nanoTime();
    //     System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    // }


