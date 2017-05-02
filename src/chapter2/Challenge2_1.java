package chapter2;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by Assulan on 4/23/2017.
 */
public class Challenge2_1 {
    // remove duplicated from unsorted singly linked list
    // O(n^2)
    // Idea: iterate and add elements to another linked list, and return its head
    public static Node removeDuplicates(Node head){
        if (head != null){
            Node newHead = new Node(head.data);
            Node n = head.next;
            while(n != null){
                if (!newHead.contains(n.data)){
                    newHead.appendToTail(n.data);
                }
                n = n.next;
            }
            head = newHead;
        }
        return head;
    }

    // Remove without temporary buffer
    // O(n)
    public static Node removeDuplicates2(Node head){
        Node n = head;
        Node prev = null;
        int mask = 0;
        while (n != null){
            if ((mask & (1 << n.data)) > 0){
                // duplicate
                prev.next = n.next;
            }
            else{
                mask = mask | (1 << n.data);
                prev = n;
            }
            n = n.next;
        }
        return head;
    }

    // Remove in O(n) using hash table
    public static void removeDups(Node head){
        Hashtable hashtable = new Hashtable();
        Node current = head;
        Node prev = null;
        while (current != null){
            if (hashtable.containsKey(current.data)){
                // skip it
                prev.next = current.next;
            }
            else {
                // put the value into hashtable
                hashtable.put(current.data, true);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args){
        Node head = new Node(5);
        head.appendToTail(5);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(1);
        System.out.println(head);
//        head = removeDuplicates2(head);
        removeDups(head);
        System.out.println(head);
    }

}
