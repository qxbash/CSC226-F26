package medical_action_tracking;

public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        // COMPLETED: Initialize an empty queue.
        front = null;
        rear = null; 
        size = 0;
    }

    public void enqueue(T item) {
        //  COMPLETED: Add a node at the rear. Update both references when the queue is empty.
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue nothing!");
        }
        Node newNode = new Node(item); // new node

        if (isEmpty()) {     
            front = newNode;   // facilitates if it is empty
            rear = newNode;
        }
        else {
            rear.next = newNode; // does not change front
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        // COMPLETED: Remove and return the front item, or return null if empty.
        // COMPLETED: When removing the last item, make both front and rear null.
        if (isEmpty()) {
            return null;
        }
        T item = front.data;
        front = front.next;
        size --;
        if (front == null) {
            rear = null;
        }
        return item;


    }

    public T peekFront() {
        // COMPLETED: Return the front item without removing it, or null if empty.
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    public boolean isEmpty() {
        // COMPLETED: Determine whether the queue contains any items.
        return size == 0;
    }

    public int size() {
        // COMPLETED: Return the number of queued items.
        return size;
    }

    @Override
    public String toString() {
        // COMPLETED: Recursively build a string from front to rear without changing the queue.
        StringBuilder result = new StringBuilder("[");
        appendNodesRecursively(front, result);
        result.append("]");
        return result.toString();
    }

    private void appendNodesRecursively(Node current, StringBuilder result) {
        // COMPLETED: Add the current node's data, then recursively visit current.next.
        // COMPLETED: Stop at the null-node base case.
        if (current == null) {
             return;}
        result.append(current.data);
        if (current.next != null) {
            result.append(", ");}
        appendNodesRecursively(current.next, result);
    }
}
