import week5.LinkedQueue;

public class Main {  
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);  
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);  
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);  
        queue.enqueue(9);

           
        // Dequeue elements and print them
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); 

        // Check if the queue is empty
        System.out.println(queue.isEmpty()); 

        // Dequeue the last element
        System.out.println(queue.dequeue()); 
        // Check if the queue is empty again
        System.out.println(queue.isEmpty());

        // Try to dequeue from an empty queue
        System.out.println(queue.dequeue()); //  Queue is empty. Cannot dequeue. 
    }

     
}