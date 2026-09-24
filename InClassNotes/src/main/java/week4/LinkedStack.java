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

        // sets current top 
        LLNode<T> currentTop = top; 

        T returnedData = currentTop.getInfo();

        top = currentTop.getNext();
        
    }
    public T top(){
        //return the data in the element from the top of the stack
        //note: what preconditions do we care about?
        return ; // placeholder
    }

    public boolean isEmpty(){
        return false; //placeholder
    }
    public boolean isFull(){
        return true; //placeholder
    }
}