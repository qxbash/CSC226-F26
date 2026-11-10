package staff_assignment;

public class Main {
    public static void main(String[] args) {
        StaffRoster roster = new StaffRoster();

        // 1. adds staff across all four levels
        roster.addStaff(new StaffMember("T1", "Tina Tech", Seniority.TECH));
        roster.addStaff(new StaffMember("N1", "Nora Nurse", Seniority.NURSE));
        roster.addStaff(new StaffMember("N2", "Ned Nurse", Seniority.NURSE));
        roster.addStaff(new StaffMember("R1", "Riley Resident", Seniority.RESIDENT));
        roster.addStaff(new StaffMember("A1", "Dr. Avery Attending", Seniority.ATTENDING));

        System.out.println("=== Starting roster (" + roster.size() + " staff) ===");
        roster.displayRoster();

        // 2. Assign treatments (assignTreatment records performedBy in the Week 3 history)
        System.out.println("\n=== Assigning treatments ===");
        StaffMember s1 = roster.assignTreatment("P001", "Blood draw", "2026-11-09 09:00", Seniority.TECH);
        System.out.println("P001 Blood draw -> " + s1.getName() + " (" + s1.getStaffId() + ")");

        StaffMember s2 = roster.assignTreatment("P002", "IV start", "2026-11-09 09:10", Seniority.NURSE);
        System.out.println("P002 IV start -> " + s2.getName() + " (" + s2.getStaffId() + ")");

        StaffMember s3 = roster.assignTreatment("P003", "Cardiac surgery", "2026-11-09 09:20", Seniority.ATTENDING);
        System.out.println("P003 Cardiac surgery -> " + s3.getName() + " (" + s3.getStaffId() + ")");

        StaffMember s4 = roster.assignTreatment("P004", "Wound care", "2026-11-09 09:30", Seniority.NURSE);
        System.out.println("P004 Wound care -> " + s4.getName() + " (" + s4.getStaffId() + ")");

        System.out.println("\n=== Roster after assignments ===");
        roster.displayRoster();

        // 3. Undo the globally most recent assignment (P004)
        System.out.println("\n=== Undo last assignment ===");
        StaffMember undone = roster.undoLastAssignment();
        System.out.println("Undid assignment for: " + undone);

        // 4. Release a finished case
        System.out.println("\n=== Release a finished case ===");
        roster.release(s3);
        System.out.println("Released: " + s3.getName() + ", load now " + s3.getCaseLoad());

        System.out.println("\n=== Final roster ===");
        roster.displayRoster();
    }
}