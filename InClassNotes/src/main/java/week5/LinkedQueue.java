package week5;

public class LinkedQueue<T> implements QueueInterface<T> {
    private LLNode<T> front;
    private LLNode<T> rear;

    @Override
    public void enqueue(T element) {
     LLNode<T> newNode = new LLNode<>(element); // Initialize
      
     if (isEmpty()) {
        front = newNode;
        rear = newNode;
       }
       else {
        rear.setNext(newNode);
        rear = newNode;
       }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!"); 
            return null;
        }
        else { 
           LLNode<T> removedElement = front.getInfo();
            front = front.getNext();
            if ( front == null) {
                rear = null;
            }
            return removedElement;
        }
    }


    @Override
    public boolean isFull() {
        if (isFull()) {
            return true;
        } 
        else {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }
}