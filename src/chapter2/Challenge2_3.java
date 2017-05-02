package chapter2;

/**
 * Created by Assulan on 4/27/2017.
 */
public class Challenge2_3 {

    // Removes given node from the singly linked list
    // Does not work if the node is the last one.
    public static boolean removeNode(Node node){
        if (node == null || node.next == null) return false;
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        System.out.println(head);
        Node node = head.next.next.next.next;
        removeNode(node);
        System.out.println(head);
    }
}
