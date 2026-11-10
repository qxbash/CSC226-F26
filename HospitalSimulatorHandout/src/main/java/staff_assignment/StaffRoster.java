package staff_assignment;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.NoSuchElementException; // for when an Element is not found
import medical_action_tracking.TreatmentHistory;
import medical_action_tracking.TreatmentRecord;

public class StaffRoster {
    // Week 3 stack-based history; every assignment is recorded here so it can be undone.
    private final TreatmentHistory history = new TreatmentHistory();

    // Outer map groups staff by seniority; each inner set is sorted by StaffMember's ordering.
    private final TreeMap<Seniority, TreeSet<StaffMember>> tiers = new TreeMap<>();

    // COMPLETED: Add the staff member to the correct tier, and reject a duplicate staffId.
    public void addStaff(StaffMember staff) {
        // IT WILL REJECT DUPLICATES!!
        if (findById(staff.getStaffId())!= null) {
            throw new IllegalArgumentException("staffID Duplicate!: " + staff.getStaffId());
        }
        Seniority level = staff.getSeniority(); // checks the persons tier

        TreeSet<StaffMember> tierSet = tiers.get(level); // looks up that tier's set 

        if  (tierSet == null) {
            tierSet = new TreeSet<>(); // makes the set and stores it
            tiers.put(level, tierSet);
        }
        tierSet.add(staff); // appends to the set
    }

    // COMPLETED: Pick the least-loaded staff member at or above "required", raise their load by 1, and return them.
    public StaffMember assign(Seniority required) {
        StaffMember best = null;
        // only tiers at the same level or above required, priortizes lowest seniority first 
        for (TreeSet<StaffMember> tier : tiers.tailMap(required, true).values()) {
            if(tier.isEmpty()) {
                continue;
            }
            StaffMember candidate = tier.first();

            if (best ==null || candidate.getCaseLoad() < best.getCaseLoad()) { // lower load wins
                best = candidate;
            }
        }
        if (best == null) {
            throw new NoSuchElementException("No staff available at or above " + required);
        }
        changeLoad(best, best.getCaseLoad() + 1); // removes, adjust, and adds back
        return best;  
    }

    // COMPLETED: Lower the staff member's load by 1 (never below 0) and keep the tree ordered.
    public void release(StaffMember staff) {
        // utilizes the object that is stored in a tree
        StaffMember member = findById(staff.getStaffId());
        if (member == null) {
            return;                         // nothing in roster 
        }
        if (member.getCaseLoad() > 0) { // never drop below a 0
            changeLoad(member, member.getCaseLoad() -1);
        }
    }

    // COMPLETED: Return how many staff members are in the roster.
    public int size() {
        int total = 0;
        for (TreeSet<StaffMember> tier : tiers.values()) {
            total += tier.size();
        }
        return total;
    }

   // COMPLETED: Print each tier, most senior first, listing its staff in order.
    public void displayRoster() {
        for (Seniority level : tiers.descendingMap().keySet()) {
            System.out.println(level + ":");
            for(StaffMember member : tiers.get(level)) {
                System.out.println("  " + member);   // uses StaffMember's toString  
            }
        }
    }

    // COMPLETED: Remove the member, set the new load, then add them back (the only safe way to change a load).
    private void changeLoad(StaffMember member, int newLoad) {
        TreeSet<StaffMember> tier = tiers.get(member.getSeniority());
        tier.remove(member); // removes while the old load is still entered
        member.setCaseLoad(newLoad); // changes the load 
        tier.add(member); // appends it in its spot
    }

    // COMPLETED: Call assign(), record the treatment in history with the chosen staffId, and return that staff member.
    public StaffMember assignTreatment(String patientID, String treatment, String timestamp, Seniority required) {
        StaffMember chosen = assign(required); // rids it if nobody qualifies
        history.addTreatment(patientID, treatment, timestamp, chosen.getStaffId());
        return chosen;
    }

    // COMPLETED: Pop the globally most recent treatment with your Week 3 undo, release whoever performed it, and return them (null if none).
    public StaffMember undoLastAssignment() {
        TreatmentRecord record = history.undoLastAction();
        if (record == null) {
            return null;  // there is no history!
        }
        StaffMember member = findById(record.getPerformedBy());
        release(member); // will release a null member properly??
        return member;
    }

    // COMPLETED: Return the staff member with this staffId, or null if they are not in the roster.
    private StaffMember findById(String staffId) {
        for (TreeSet<StaffMember> tier : tiers.values()) {  // Checks each tier and every member 
            for (StaffMember member : tier) {
                if (member.getStaffId().equals(staffId)) {
                    return member;
                }
            }
        }
        return null;
    }
}
