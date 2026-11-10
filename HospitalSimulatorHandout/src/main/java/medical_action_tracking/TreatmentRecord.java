package medical_action_tracking;

public class TreatmentRecord {
    private String patientID;
    private String treatmentName;
    private String timestamp;
    private String performedBy;  

    public TreatmentRecord(String patientID, String treatmentName, String timestamp) {
        this(patientID, treatmentName, timestamp, null);
    }

    // 4-argument constructor
    public TreatmentRecord(String patientID, String treatmentName,
                           String timestamp, String performedBy) {
        this.patientID = patientID;
        this.treatmentName = treatmentName;
        this.timestamp = timestamp;
        this.performedBy = performedBy;
    }

    public String getPatientID() {
        // COMPLETED: Return the patient ID.
        return patientID;
    }

    public String getTreatmentName() {
        // COMPLETED: Return the treatment description.
        return treatmentName;
    }

    public String getTimestamp() {
        // COMPLETED: Return the timestamp.
        return timestamp;
    }

    // getter for performedBy
    public String getPerformedBy() {
        return performedBy;
    }

    @Override
    public String toString() {
        // COMPLETED: Return "timestamp | patientID | treatmentName".
        return timestamp + " | " + patientID + " | " + treatmentName;
    }
}