package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Assulan on 4/29/2017.
 */
class SetOfStacks{
    int threshold = 2;
    List<Stack<Integer>> stackList;
    int currentStack;

    public SetOfStacks(){
        stackList = new ArrayList<>();
        stackList.add(new Stack<>());
        currentStack = 0;
    }

    public void push(int value){
        if (stackList.get(currentStack).size() == threshold){
            // current stack is full
            stackList.add(new Stack<>());
            currentStack++;
        }
        stackList.get(currentStack).push(value);
    }

    public int pop() throws Exception{
        if (currentStack < 0) throw new Exception("Empty stack");
        int value = stackList.get(currentStack).pop();
        if (stackList.get(currentStack).isEmpty()){
            stackList.remove(currentStack);
            currentStack--;
        }
        return value;
    }

    @Override
    public String toString() {
        String str = "";
        for (Stack s : stackList){
            str += s.toString();
        }
        return str;
    }
}

public class Challenge3_3 {

    public static void main(String[] args) throws Exception {
        SetOfStacks stacks = new SetOfStacks();
        for (int i = 0; i < 10; i++){
            stacks.push(i);
        }
        System.out.println(stacks);
        stacks.pop();
        stacks.pop();
        System.out.println(stacks);
    }
}
