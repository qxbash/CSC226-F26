package week4;

import java.util.ArrayList;

public class LinkedListExamples {
    public static void main(String[] args){
        // Create a sample linked list for testing
        LLNode<String> head = new LLNode<>("First");
        head.setNext(new LLNode<>("Second"));
        head.getNext().setNext(new LLNode<>("Third"));
        head.getNext().getNext().setNext(new LLNode<>("Fourth"));
        
        // Test your functions here
        
    }
    
    
    /**
     * 2. Program to display both elements and their position in a linked list
     * Shows: Position 0: "First", Position 1: "Second", etc.
     */
    public static <T> void displayWithPositions(LLNode<T> head) {  
        int counter = 0;
        for (LLNode<T> current = head; current != null; current = current.getNext(), counter++) {
            System.out.print(counter + " " + current.getInfo());
        } 
    }
    
    /**
     * 3. Program to remove a specified element from a linked list
     * Returns the new head of the list (important if first element is removed)
     */
    public static <T> LLNode<T> removeElement(LLNode<T> head, T target) {
        // Handle special case: removing the first element
        if (head != null && head.getInfo().equals(target)) {
            return head.getNext();
        }
        
        // For other elements: find the node before the target
        LLNode<T> current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getInfo().equals(target)) {
                current.setNext(current.getNext().getNext());
                return head; 
            }
            current = current.getNext();
        }
        
        return head; // Target not found, return original list unchanged
    }
    
    /**
     * 4. Program to remove all elements from a linked list
     * Returns null (empty list)
     */
    public static <T> LLNode<T> removeAllElements(LLNode<T> head) {
        return null;
    }
    
    /**
     * 5. Program to copy a linked list to another linked list
     * Creates a completely new list with the same values
     */
    public static <T> LLNode<T> copyList(LLNode<T> original) {
        // Handle empty list case
        if (original == null) {
            return null;
        }
    
        // Create first node for the copy
        LLNode<T> copyHead = new LLNode<>(original.getInfo());
        LLNode<T> currentOriginal = original.getNext();
        LLNode<T> currentCopy = copyHead;

        // Continue copying remaining nodes
        while (currentOriginal != null) {
            currentCopy.setNext(new LLNode<>(currentOriginal.getInfo()));
            currentCopy = currentCopy.getNext();
            currentOriginal = currentOriginal.getNext();
        }

        return copyHead;
    }

    /**
     * 6. Program to check if a particular element exists in a linked list
     * Returns true if found, false otherwise
     */
    public static <T> boolean contains(LLNode<T> head, T target) {
        LLNode<T> current = head;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    /**
     * Helper function to calculate the length of a linked list
     * Useful for other operations
     */
    public static <T> int getLength(LLNode<T> head) {
        int count = 0;
        LLNode<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * 7. Program to convert a linked list to an array list
     * Returns an ArrayList containing all elements in the same order
     */
    public static <T> ArrayList<T> toArrayList(LLNode<T> head) {
        ArrayList<T> result = new ArrayList<>();
        LLNode<T> current = head;
        
        while (current != null) {
            result.add(current.getInfo());
            current = current.getNext();
        }
        
        return result;
    }
        
    /**
     * Helper function to get the element at a specific position
     * Returns null if position is out of bounds
     */
    public static <T> T getElementAt(LLNode<T> head, int position) {
        LLNode<T> current = head;
        int index = 0;
        
        while (current != null && index <= position) {
            if (index == position) {
                return current.getInfo();
            }
            current = current.getNext();
            index++;
        }
        
        return null; // Position out of bounds or not found
    }
}

