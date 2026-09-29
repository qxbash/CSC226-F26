package week4;
import week3.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    private LLNode<T> top;

    public LinkedStack(){
        this.top=null;
    }

    public void push(T element){
        //Push an element to the top of the stack
        LLNode<T> newNode = new LLNode<>(element);

        newNode.setNext(top);

        top = newNode;
    }
    public void pop(){
        //remove an element from the top of the stack
        //note: what preconditions do we care about?

        if (isEmpty()) {
            return; // Cannot pop from empty stack
        }

        LLNode<T> currentTop = top;
        T poppedElement = currentTop.getInfo();

        top = currentTop.getNext();
    }

    public T top(){
        // return the data in the element from the top of the stack
        if (isEmpty()) {
            return null;
        }
        return top.getInfo(); 
    }
    

    public boolean isEmpty(){
        return top == null; // Stack is empty when top is null
    }
    public boolean isFull(){
        return false; 
    }
}

