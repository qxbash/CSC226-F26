package week4;


public class Recursion {
    public int fib(int n){
        if (n == 0 || n == 1) 
            return n;
        return  fib(n -1) + fib(n-2);
        
    }
    public static Integer countHi(String value){
    if (value == null || value.length() < 2) {
        return 0;
    }
    if (value.substring(0, 2).equals("hi")) {
        
        return 1 + countHi(value.substring(2));
    } else {
       
        return countHi(value.substring(1));
    }
}
public static <T> void iterativePrinter(LLNode<T> node){
        while(node !=null){
            if(node.getInfo()!=null){
                System.out.println(node.getInfo());
            }
            node=node.getNext();
        }
    }
    public static <T> void recursivePrinter(LLNode<T> node){
       if(node != null) {
        System.out.println(node.getInfo());
        recursivePrinter(node.getNext());
    }

}

    public static <T> int recursiveCounter(LLNode<T> node, int counter){
    if(node != null) {
        // Move to next node and increment counter
        return recursiveCounter(node.getNext(), counter + 1);
    } else {
        // Base case: reached end of list
        return counter;
    }

}

