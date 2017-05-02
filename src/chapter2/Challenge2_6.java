package chapter2;

import java.util.Hashtable;

/**
 * Created by Assulan on 4/28/2017.
 */
public class Challenge2_6 {
    public static boolean hasLoop(Node n){
        if (n == null || n.next == null) return false;
        Node slowRunner = n, fastRunner = n.next;
        while (true){
            if (slowRunner.data == fastRunner.data) return true;
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
    }

    // O(n) time and space
    public static Node findBeginning(Node head){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // collision point
        }
        // error check, no collision, thus no loop
        if (fast == null || fast.next == null) return null;
        // move slow to head. Keep fast at collision point.
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        // both point to the start of the loop
        return fast;
    }

    public static void main(String[] args){
        Node n1 = new Node(7);
        Node n2 = new Node(6);
        Node n3 = new Node(5);
        Node n4 = new Node(4);
        Node n5 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;

        System.out.println(hasLoop(n1));
        System.out.println(findBeginning(n1).data);
    }
}
