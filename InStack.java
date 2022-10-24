import java.util.Stack;

public class InStack {
    public static void main(String[] args) {
        Stack <Integer> stk = new Stack <Integer>();

        System.out.println("Stack is empty? : "+stk.empty());
        
        stk.push(22);
        stk.push(31);
        stk.push(23);
        stk.push(12);
        stk.push(45);
        stk.push(98);
        stk.push(36);
        stk.push(81);
        
        System.out.println("Now the stack elements are : "+stk);
        
        stk.pop();
        stk.pop();
        System.out.println("Now the stack elements are : "+stk);

        System.out.println("Now the top element of stack is : "+stk.peek());

        System.out.println("Size of stack is : "+stk.size());
        
        System.out.println("Search element position of the stack is : "+stk.search(23));
        
        System.out.println("Stack is empty? : "+stk.empty());

    }

}
