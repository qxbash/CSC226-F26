package week3;

public class ArrayBoundedStack<T> implements StackInterface<T> {
    private final int DEFAULTCAP = 100;
    private T[] elements;
    private int topIndex=-1;

    public ArrayBoundedStack(){
        elements = (T[]) new Object[DEFAULTCAP];
    }
    
    public ArrayBoundedStack(int maxSize){
        elements = (T[]) new Object[maxSize];
    }
    
    public boolean isEmpty()
    {
        //TODO: how do we determine if the stack is empty? Implement this method
        
        return topIndex == -1; 
    } // The stack cannot be negative, if it is negative, it is empty.

    public boolean isFull()
    {
        //TODO: How do we determine if the stack is full? Implement this method
        return topIndex + 1 == elements.length; // Checks whether the the stack is full by checking the size of the elements inside
    }
    
    public void push(T element)
    {
       // TODO: How do we add an element to the stack? Implement this method
       if (!isFull()) {
         // If it is not full it adds an additional element to the stack.
        topIndex ++;
        elements[topIndex] = element;
       }
    } 
    
    public void pop()
    {
        // How do we remove an element from the stack? Implement this method
        if (!isEmpty()) { 
        topIndex --;
        }
    }
    
    public T top()
    {
        if (isEmpty()){
            return null;
        }
      // How do we return the top element of the stack without removing it? Implement this method
      // Returns nothing if empty, or it will return the latest element in the index.
      return elements[topIndex];   
    }
}