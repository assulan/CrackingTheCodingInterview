package chapter3;


/**
 * Created by Assulan on 4/29/2017.
 */
public class Stack {
    Node top;

    Object pop(){
        if (top != null){
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item){
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    Object peek(){
        return top != null ? top.data : null;
    }
}
