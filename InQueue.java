import java.util.PriorityQueue;

public class InQueue {
    
    public static void main(String[] args) {
        
        PriorityQueue <Integer> que = new PriorityQueue<>();
        
        
        System.out.println("Queue is empty? : "+que.isEmpty());

        que.add(12);
        que.add(45);
        que.add(74);
        que.add(98);
        que.add(47);
        que.add(35);
        que.add(68);
        que.add(57);

        System.out.println("Now the queue elements are : "+que);
        
        que.remove();
        que.remove();
        
        System.out.println("Now the queue elements are : "+que);
        
        System.out.println("Now the top element of queue is : "+que.peek());

        System.out.println("Size of queue is : "+que.size());
                
        System.out.println("Queue is empty? : "+que.isEmpty());
        
    }


}
