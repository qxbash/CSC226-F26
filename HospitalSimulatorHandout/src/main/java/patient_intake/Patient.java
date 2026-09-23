package patient_intake;

public class Patient extends Person {
    private String patientID;
    private String chiefComplaint;
    private int triageLevel;
    private String currentStage;
    private String assignedRoom;
    private int arrivalHour;
    private String insuranceID;

    public Patient(String patientID, String firstName, String lastName, int age, 
                   String chiefComplaint, int triageLevel, String currentStage, 
                   String assignedRoom, int arrivalHour, String insuranceID) {
        super(firstName, lastName, age);
        // COMPLETED: Initialized the rest of the patient fields.
        this.patientID = patientID;
        this.chiefComplaint = chiefComplaint;
        this.triageLevel = triageLevel;
        this.currentStage = currentStage;
        this.assignedRoom = assignedRoom;
        this.arrivalHour = arrivalHour;
        this.insuranceID = insuranceID;
    }

    // Getters
    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public String getCurrentStage() {
        return currentStage;
    }

    public String getAssignedRoom() {
        return assignedRoom;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }

    public String getInsuranceID() {
        return insuranceID;
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;    
         // COMPLETED: Update the patient ID.
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
         // COMPLETED: Update the first name.
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        // COMPLETED: Update the last name.
    }

    public void setAge(int age) {
        // COMPLETED: Update the age.
        // COMPLETED OPTIONAL (+5%): Reject ages outside the range 0 through 120.
        if (age >= 0 && age <= 120) {
        this.age = age;   // Only assign valid age
    }
    }

    public void setChiefComplaint(String chiefComplaint) {
    this.chiefComplaint = chiefComplaint;  
}

    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel;        
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;      
    }

    public void setAssignedRoom(String assignedRoom) {
        this.assignedRoom = assignedRoom;      
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour;         
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;        
    }

    @Override
    public String toString() {
         return "Patient{" +
            "patientID='" + this.patientID + '\'' +
            ", firstName='" + this.firstName + '\'' +
            ", lastName='" + this.lastName + '\'' +
            ", age=" + this.age +
            ", chiefComplaint='" + this.chiefComplaint + '\'' +
            ", triageLevel=" + this.triageLevel +
            ", currentStage='" + this.currentStage + '\'' +
            ", assignedRoom='" + this.assignedRoom + '\'' +
            ", arrivalHour=" + this.arrivalHour + '\'' +
            ", insuranceID='" + this.insuranceID;
} // COMPLETED: Return a useful representation of a patient.
    }



