package week10;

/**
 * WEEK 10 - HASH COLLISION RACE
 *
 * Your job: implement the three methods below (linear, quadratic, bucket).
 * Do NOT edit any other file. Run HashRaceVisualizer.main to watch your code race.
 *
 * Rules shared by all three methods:
 *   - The hash function is:  index = (int) (key % tableSize)
 *   - Keys are positive, unique longs (cast the hash with (int) (key % tableSize)); you only need insert (no search / remove).
 *   - Call progress.update(inserted, collisions) every PROGRESS_EVERY inserts
 *     (and once more at the very end) so the charts can draw your progress live.
 *     The 2nd chart plots (new collisions / new inserts) between updates: the cost of each insert.
 *   - Return a long[] of exactly two values:  { inserted, collisions }
 * 
 * What counts as a collision:
 *   - linear / quadratic: every probe that lands on an OCCUPIED slot
 *       (home slot occupied = 1 collision, then one more for each extra occupied slot you hit)
 *   - bucket: every insert whose bucket already has at least one node in it (count 1 per insert)
 */
public class HashRace {

    public static final int PROGRESS_EVERY = 500;

    /** Provided node for the bucket (separate chaining) version. */
    static class Node {
        long key;
        Node next;

        Node(long key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /**
     * LINEAR PROBING: if index is taken, try index+1, index+2, ... (wrap around with % tableSize).
     *
     * @param keys      the keys to insert, in order
     * @param tableSize length of the table to create (always bigger than keys.length)
     * @param progress  call progress.update(inserted, collisions) every PROGRESS_EVERY inserts and at the end
     * @return long[]{ inserted, collisions }   e.g. new long[]{100000, 412345}
     */
    // COMPLETED
public static long[] linear(long[] keys, int tableSize, ProgressListener progress) {
    long[] table = new long[tableSize];
    long inserted = 0;
    long collisions = 0;

    for (long key : keys) {
        int home = (int) (key % tableSize);
        int index = home;

        while (table[index] != 0) {
            collisions++;
            index = (index + 1) % tableSize;
        }
        table[index] = key;
        inserted++;

        if (inserted % PROGRESS_EVERY == 0) {
            progress.update(inserted, collisions);
        }
    }
    progress.update(inserted, collisions);
    return new long[]{inserted, collisions};
}
    /**
     * QUADRATIC PROBING: if index is taken, try index+1^2, index+2^2, index+3^2, ... (all % tableSize).
     * Use long for the offset math so i*i can't overflow.
     *
     * @param keys      the keys to insert, in order
     * @param tableSize length of the table to create (always a prime bigger than 2 * keys.length)
     * @param progress  call progress.update(inserted, collisions) every PROGRESS_EVERY inserts and at the end
     * @return long[]{ inserted, collisions }   e.g. new long[]{100000, 412345}
     */
    public static long[] quadratic(long[] keys, int tableSize, ProgressListener progress) {
        // COMPLETED
        long[] table = new long[tableSize]; // 0 would indicate an empty slot
        long inserted = 0; // start at 0
        long collisions = 0; // start at 0

        for (long key : keys) {
            int home = (int) (key % tableSize);
            int index = home;
            long i = 0;

            while (table[index] != 0) {
                collisions ++;
                i++; // prevent overflowing using long variable  
                index = (int) ((home + i * i ) % tableSize);
            }
           table[index] = key;
           inserted++;

           if (inserted % PROGRESS_EVERY == 0) {
                progress.update(inserted, collisions);
           }
        }
        progress.update(inserted, collisions); 
        return new long[]{inserted, collisions};
    }

    /**
     * BUCKETS: each table slot holds the head of a linked list (Node). Insert the new node at the HEAD of
     * the list at key % tableSize.
     *
     * @param keys      the keys to insert, in order
     * @param tableSize number of buckets (array of Node heads)
     * @param progress  call progress.update(inserted, collisions) every PROGRESS_EVERY inserts and at the end
     * @return long[]{ inserted, collisions }   e.g. new long[]{100000, 99999}
     */
    public static long[] bucket(long[] keys, int tableSize, ProgressListener progress) {
    Node[] table = new Node[tableSize];
    long inserted = 0;
    long collisions = 0;

    for (long key : keys) {
        int index = (int) (key % tableSize);

        if (table[index] != null) {
            collisions++;               // bucket already contains a node
        }
        table[index] = new Node(key, table[index]);   // insert at head of linked list 
        inserted++;

        if (inserted % PROGRESS_EVERY == 0) {
            progress.update(inserted, collisions);
        }
    }
    progress.update(inserted, collisions);
    return new long[]{inserted, collisions};
    }
}