package week4;


public class Recursion {
    public int fib(int n){
        if (n == 0 || n == 1) 
            return n;
        return  fib(n -1) + fib(n-2);
        
    }
    public static Integer countHi(String value){
    

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
       return  
    }

    public static <T> int recursiveCounter(LLNode<T> node, int counter){
        
    }

}
