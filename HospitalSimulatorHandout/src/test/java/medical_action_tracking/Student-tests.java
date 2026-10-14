package medical_action_tracking;
import org.junit.jupiter.api.Test;
import patient_intake.Patient;

import static org.junit.jupiter.api.Assertions.*;

/** Student-written tests covering cases the instructor examples do not. */
class StudentCareTests {

    // 1. Transition to and from exactly one element, then reuse the queue.
    @Test
    void queueReturnsToEmptyAfterOneItemAndCanBeReused() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("only");
        assertEquals(1, queue.size());
        assertEquals("[only]", queue.toString());

        assertEquals("only", queue.dequeue());
        assertTrue(queue.isEmpty());
        assertEquals("[]", queue.toString());

        queue.enqueue("again");   // front and rear must have been reset correctly
        assertEquals("again", queue.peekFront());
        assertEquals(1, queue.size());
    }

    // 2. FIFO order holds when enqueues and dequeues are interleaved.
    @Test
    void queueKeepsFifoWhenEnqueueAndDequeueAreInterleaved() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals("[2, 3, 4]", queue.toString());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertNull(queue.dequeue());
    }

    // 3. Recursive toString on many nodes is repeatable and does not mutate.
    @Test
    void recursiveToStringIsRepeatableAndLeavesQueueIntact() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        String first = queue.toString();
        String second = queue.toString();

        assertEquals("[1, 2, 3, 4, 5]", first);
        assertEquals(first, second);
        assertEquals(5, queue.size());
        assertEquals(1, queue.peekFront());
    }

    // 4. Priority across all four lanes, regardless of arrival order; invalid level changes nothing.
    @Test
    void waitingRoomServesLevelsOneThroughFourAndIgnoresInvalidLevel() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        Patient p4 = patient("P4", 4);
        Patient p2 = patient("P2", 2);
        Patient p3 = patient("P3", 3);
        Patient p1 = patient("P1", 1);
        room.addPatient(p4);
        room.addPatient(p2);
        room.addPatient(p3);
        room.addPatient(p1);

        assertFalse(room.addPatient(patient("BAD", 0)));
        assertEquals(4, room.size());

        assertSame(p1, room.nextPatient());
        assertSame(p2, room.nextPatient());
        assertSame(p3, room.nextPatient());
        assertSame(p4, room.nextPatient());
        assertNull(room.nextPatient());
    }

    // 5. LIFO order with interleaved push/pop.
    @Test
    void stackKeepsLifoOrderWithInterleavedPushAndPop() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.pop());
        stack.push("c");

        assertEquals("c", stack.peek());
        assertEquals(2, stack.size());
        assertEquals("[c, a]", stack.toString());
    }

    // 6. Undo everything, then reuse the log; display is repeatable.
    @Test
    void historyCanBeUndoneToEmptyAndThenReused() {
        TreatmentHistory history = new TreatmentHistory();
        history.addTreatment("P001", "Assessment", "2026-09-27 09:00");
        history.addTreatment("P002", "X-ray", "2026-09-27 09:05");

        assertEquals(history.displayHistory(), history.displayHistory());
        assertEquals("X-ray", history.undoLastAction().getTreatmentName());
        assertEquals("Assessment", history.undoLastAction().getTreatmentName());
        assertNull(history.undoLastAction());
        assertEquals("[]", history.displayHistory());

        history.addTreatment("P003", "Stitches", "2026-09-27 10:00");
        assertEquals("[2026-09-27 10:00 | P003 | Stitches]", history.displayHistory());
    }

    private Patient patient(String id, int level) {
        return new Patient(id, "Test", "Patient", 30, "Checkup", level,
                "Waiting", "ER-001", 9, "INS-001");
    }
}
}
