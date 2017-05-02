package chapter3;

import java.util.*;

/**
 * Created by Assulan on 4/29/2017.
 * Stack that has min operations that returns smallest value.
 * All operations should be O(n).
 */
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

public class Challenge3_2 {

    public static void main(String[] args){
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(5);
        stackWithMin.push(4);
        stackWithMin.push(7);
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }
}
