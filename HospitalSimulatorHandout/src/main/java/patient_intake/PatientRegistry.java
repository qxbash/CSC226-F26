package patient_intake;
// Switch from using ArrayList to a flat array implementation for patient storage.

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored patients.
    private Patient[] patientRegistry;
    private int size; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        // COMPLETED: Create the initial array and set the starting size.
        this.patientRegistry = new Patient[INITIAL_CAPACITY];
        this.size = 0;
}

    public void addPatient(Patient patient) {
         if (size == patientRegistry.length) {
        Patient[] newRegistry = new Patient[patientRegistry.length * 2];
        
        // ← Copy all current patients into new, larger array
        for (int i = 0; i < size; i++) {
            newRegistry[i] = patientRegistry[i];
        }
        
        patientRegistry = newRegistry;  // Replaces old array with new one
    }
    
    patientRegistry[size] = patient;   // Store new patient in current position
    size++;                            // Increment the count of stored patients
}

        // COMPLETED: Add a patient to the registry.
        // COMPLETED OPTIONAL (+5%): Expand the array when it becomes full.
    
    public Patient[] getPatientRegistry() {
        // Creates hardened copy to prevent external modification
        Patient[] copy = new Patient[size];
        
        for (int i = 0; i < size; i++) {
            copy[i] = patientRegistry[i];  // ←Copy only the stored patients
        }
        
        return copy;   // Return the hardened copy, not the backing array
    } 
        // COMPLETED: Return the patients currently stored.
    

    public Patient getPatientByID(String patientID) {
        for (int i = 0; i < size; i++) {
        
         if (patientRegistry[i].getPatientID().equals(patientID)) {
            return patientRegistry[i];   // Returns the matching patient
        }
    }
    
    return null; 
        // COMPLETED: for and return the matching patient.
    }

    /**
     * Removes a patient from the registry by patientID.
     * param patientID The ID of the patient to remove
     * return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID) {
         int index = -1;  // TrackS where patient is found
    
    // Find patient by ID
    for (int i = 0; i < size; i++) {
        if (patientRegistry[i].getPatientID().equals(patientID)) {
            index = i;   
            break;      
        }
    }
    
    //  If patient wasn't found, return false
    if (index == -1) {
        return false;
    }
    
    // Remove patient by shifting remaining elements left
    for (int i = index + 1; i < size; i++) {
            patientRegistry[i - 1] = patientRegistry[i];
        }
        
        patientRegistry[size - 1] = null;  // Clear last slot to help garbage collector
        
        size--;   // Decrement stored count
        
        return true; 
    }

        // COMPLETED OPTIONAL: (+5%): Remove the patient with this ID.
    

    /**
     * Removes a patient from the registry by index.
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {
        // Check if index is valid
        if (index < 0 || index >= size) {
            return null;   
        }
        
        Patient removed = patientRegistry[index];  // Remember the patient to return
        
        // Shift all elements after this position one slot left
        for (int i = index + 1; i < size; i++) {
            patientRegistry[i - 1] = patientRegistry[i];
        }
        
        patientRegistry[size - 1] = null;   // Clear last slot
        
        size--;   // Decrement stored count
        
        return removed;   // ←
            // TODO COMPLETED (+5%): Remove by index and shift later elements left.
        }

    /**
     * Updates a patient in the registry by matching patientID.
     * param updatedPatient The patient with updated information
     * return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(updatedPatient.getPatientID())) {
                patientRegistry[i] = updatedPatient;  // Replace old 
                return true;   
            }
        }
    
        return false;   
        // COMPLETED (+5%): Replace the patient with the same ID.
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("PatientRegistry\n");

            for (int i = 0; i < size; i++) {
            Patient p = patientRegistry[i];
            result.append(p.toString());
            if (i != 0) {
                result.append("\n");
            } else {
                result.append("\nsize:");
        }
    }
        return result.toString();
}
       
        // COMPLETED: Return a useful representation of the registry.
    }

 



