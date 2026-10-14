# Big-O Analysis: Week 3 Patient Flow and Care History


| Operation | Time Complexity | Explanation |

| Queue `enqueue` / `dequeue` | O(1) | The queue keeps references to both the front and rear nodes, so adding or removing an item never requires traversing the list. |

| `EmergencyWaitingRoom.nextPatient()` | O(1) | It checks exactly four fixed lanes and performs one O(1) dequeue, so its cost does not grow with the number of waiting patients. |

| Stack `push` / `pop` / `peek` | O(1) | Each operation only reads or changes the top node and the size counter, regardless of how many items are stacked. |

| Recursive queue `toString()` | O(n) | It makes one recursive call per node, visiting each of the n nodes exactly once from front to rear. |