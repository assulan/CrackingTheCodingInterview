package chapter3;

/**
 * Created by Assulan on 4/29/2017.
 * Stack that has min operations that returns smallest value.
 * All operations should be O(1).
 */
import java.util.Stack;

class NodeWithMin{
    public int value;
    public int min;

    public NodeWithMin(int v, int min){
        value = v;
        this.min = min;
    }
}

class StackWithMin extends java.util.Stack<NodeWithMin>{
    public void push(int value){
        int newMin = Math.min(value, this.min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min(){
        if (this.isEmpty()) return Integer.MAX_VALUE;
        return peek().min;
    }
}

class StackWithMin2 extends Stack<Integer> {
    private Stack<Integer> minStack;

    public StackWithMin2(){
        minStack = new Stack<Integer>();
    }

    public void push(int value){
        if (value < min()){
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if (value == min()){
            minStack.pop();
        }
        return value;
    }

    public int min(){
        if (minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return (int) minStack.peek();
    }

}

public class Challenge3_2 {

    public static void main(String[] args){
//        StackWithMin stackWithMin = new StackWithMin();
//        stackWithMin.push(5);
//        stackWithMin.push(4);
//        stackWithMin.push(7);
//        stackWithMin.pop();
//        System.out.println(stackWithMin.min());

        StackWithMin2 stackWithMin = new StackWithMin2();
        stackWithMin.push(5);
        stackWithMin.push(4);
        stackWithMin.push(7);
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }
}
