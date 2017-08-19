package chapter3;

/**
 * Created by asus on 8/19/17.
 * Sort a stack in ascending order (biggest on top).
 */
import java.util.Stack;

class SortedStack extends Stack<Integer>{
    private Stack<Integer> tmpStack;

    public SortedStack() {
        super();
        tmpStack = new Stack<>();
    }

    @Override
    public Integer push(Integer item) {
        Integer val = null;

        if (isEmpty()){
            return super.push(item);
        }
        if (item < peek()){
            while (!isEmpty() && item < peek()){
                tmpStack.push(pop());
            }

            val = super.push(item);

            while(!tmpStack.isEmpty()){
                super.push(tmpStack.pop());
            }
        }
        else{
            super.push(item);
        }
        return val;
    }


    @Override
    public synchronized Integer pop() {
        return super.pop();
    }

    @Override
    public synchronized Integer peek() {
        return super.peek();
    }
}

public class Challenge3_6 {
    public static Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> r = new Stack<>();
        while(!s.isEmpty()){
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp){
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }

    public static void main(String[] args){
        SortedStack stack = new SortedStack();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        System.out.println("Top: " + stack.peek());

        stack.push(-1);
        System.out.println(sort(stack));
    }
}
