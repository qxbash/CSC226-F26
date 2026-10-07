package medical_action_tracking;

public class LinkedStack<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public void push(T item) {
        // COMPLETED: Reject null items, then link a new node at the top and update size.
        if (item == null) {
            throw new IllegalArgumentException("Unable to push null.");}
        
        Node newNode =  new Node(item);
        newNode.next = top;
        top = newNode;
        size ++;

    }

    public T pop() {
        // TODO: Remove and return the top item, or return null when empty.
        return null;
    }

    public T peek() {
        // TODO: Return the top item without removing it, or null when empty.
        return null;
    }

    public boolean isEmpty() {
        // COMPLETED: Determine whether the stack contains any items.
        return size == 0;
    }

    public int size() {
        // COMPLETED: Return the number of stacked items.
        return size;
    }

    @Override
    public String toString() {
        // TODO: Build [top, next, ...] by traversing the stack without changing it.
        return "[]";
    }
}
