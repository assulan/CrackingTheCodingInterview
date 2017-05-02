package chapter2;

/**
 * Created by Assulan on 4/23/2017.
 */
public class Node {
    Node next = null;
    int data;

    public Node(int d){
        data = d;
    }

    void appendToTail(int d){
        Node n = this;
        Node end = new Node(d);
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public String toString() {
        Node n = this;
        StringBuilder stringBuilder = new StringBuilder();
        while(n != null){
            stringBuilder.append(String.valueOf(n.data) + " --> ");
            n = n.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public boolean contains(int d){
        Node n = this;
        while(n != null){
            if (n.data == d) return true;
            n = n.next;
        }
        return false;
    }

    public int size(){
        int size = 0;
        Node current = this;
        while(current != null){
            current = current.next;
            size++;
        }
        return size;
    }
}
