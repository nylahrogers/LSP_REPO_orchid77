Part 1:

Shared Resource #1:
nextId

Shared Resource #2:
requests list

Concurrency Problem:
Race condition

Why addRequest() is unsafe:
Multiple threads can access getNextId() at the same time, causing 
duplicate IDs or skipped values. Also, ArrayList is not thread-safe, so 
concurrent modifications can corrupt the list.

Part 2:

Fix A:
Not correct. Synchronizing getNextId() prevents duplicate IDs, but 
requests list is still unsafe.

Fix B:
Correct. Synchronizing addRequest() ensures both ID generation and list 
addition are protected in one atomic operation.

Fix C:
Not correct. Synchronizing getRequests() does not protect writes to the 
list or ID generation.

Part 3:

Answer:
No, getNextId() should not be public.

Explanation:
According to Riel’s heuristics, internal implementation details should be 
hidden. getNextId() is part of the internal logic and should not be 
exposed to users of the class.

Part 4:

Description:
Use AtomicInteger to safely generate IDs without synchronization.

Code Snippet:
import java.util.concurrent.atomic.AtomicInteger;

private AtomicInteger nextId = new AtomicInteger(1);

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    String request = "Request-" + id + " from " + studentName;
    synchronized (requests) {
        requests.add(request);
    }
}
