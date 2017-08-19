package chapter3;

/**
 * Created by asus on 8/18/17.
 * Implement queue with 2 stacks.
 */
import java.util.Stack;

class MyQueue{
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int n){
        stack1.push(n);
    }

    public int dequeue(){
        // Pop everything from stack1 and push it to stack2 to get FIFO order
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int front = stack2.pop();

        // Put the remaining elements back to stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return front;
    }

    @Override
    public String toString() {
        String str = "";
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()){
            int val = stack2.pop();
            str += " " + val;
            stack1.push(val);
        }
        return str;
    }
}

public class Challenge3_5 {
    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        System.out.println(queue);
        queue.dequeue();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println(queue);
    }
}
