package chapter3;

import java.util.Arrays;

/**
 * Created by asus on 8/15/17.
 * Implement 3 stacks using a single array.
 */
public class Challenge3_1 {
    // Fixed size stacks
    private int stackSize = 3;
    private int[] buffer = new int[stackSize * 3];
    private int[] topPointers = {-1, -1, -1}; // pointers to the stack tops

    private void push(int stackNum, int value) throws Exception {
        // Push value to stack with stackNum
        if (topPointers[stackNum] + 1 >= stackSize){
            // reached the right boundary of the current stack
            throw new Exception("Out of space");
        }
        topPointers[stackNum]++; // move to the next position
        int pos = absolutePosition(stackNum);
        buffer[pos] = value;
    }

    private int pop(int stackNum) throws Exception{
        if (topPointers[stackNum] == -1){ // TODO error checking on the index
            throw new Exception("Empty stack");
        }
        int absPos = absolutePosition(stackNum);
        int top = buffer[absPos];
        topPointers[stackNum]--;
        return top;
    }

    private int peek(int stackNum){
        int absPos = absolutePosition(stackNum);
        return buffer[absPos];
    }

    private boolean isEmpty(int stackNum){
        return topPointers[stackNum] == -1;
    }

    private int absolutePosition(int stackNum){
        return stackNum*stackSize + topPointers[stackNum];
    }

    private void printStack(int stackNum){
        int start = stackNum * stackSize;
        int[] stack = Arrays.copyOfRange(buffer, start, start + stackSize);
        System.out.println(Arrays.toString(stack));
    }

    public static void main(String[] args) throws Exception {
        Challenge3_1 challenge = new Challenge3_1();
        challenge.push(0, 1);
        challenge.push(0, 2);
        challenge.push(0, 2);
        challenge.pop(0);
        challenge.push(0,10);
        challenge.push(1, 3);
        challenge.push(2, 4);
        challenge.push(2, 5);
        challenge.printStack(0);
        challenge.printStack(1);
        challenge.printStack(2);
    }

}
