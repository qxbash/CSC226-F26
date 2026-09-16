package patient_intake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      String filePath = "src/main/java/patient_intake/patients.csv";
      PatientRegistry patients = new PatientRegistry();

      try (Scanner fileReader = new Scanner(new File(filePath))) {
         if (fileReader.hasNextLine()) {
            fileReader.nextLine(); // Skip the CSV header.
         }

         while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(",");

              // ← Extract each field from the CSV line
            String patientID = parts[0];           // Column 0
            String fullName = parts[1];             // Column 1 
            int age = Integer.parseInt(parts[2]);   // Column 2
            String chiefComplaint = parts[3];       // Column 3
            int triageLevel = Integer.parseInt(parts[4]);  // Column 4
            String currentStage = parts[5];         // Column 5
            String assignedRoom = parts[6];         // Column 6
            int arrivalHour = Integer.parseInt(parts[7]);      // Column 7
            String insuranceID = parts[8];          // Column 8

            // ← Split full name into first and last name
            String[] nameParts = fullName.split(" ");
            String firstName = nameParts[0];      
            String lastName = nameParts[1];         
            // ← Create Patient object and add to registry
            Patient patient = new Patient(
                patientID,          
                firstName,          
                lastName,           
                age,                 
                chiefComplaint,      
                triageLevel,         
                currentStage,        
                assignedRoom,       
                arrivalHour,        
                insuranceID         
            );
            
            patients.addPatient(patient);   // ← Add to registry
            // COMPLETED: Parse the fields from parts.
            // COMPLETED: Split the full name into firstName and lastName.
            // COMPLETEED: Create a Patient and add it to patients.
         }

        System.out.println(patients.toString()); 
         // COMPLETED: Display the completed registry.
      } catch (FileNotFoundException exception) {
         // COMPLETED: Report a missing input file.
         System.err.println("Error: Could not find patients.csv file!"); 
      }
   }
}