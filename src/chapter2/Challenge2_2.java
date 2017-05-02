package chapter2;

/**
 * Created by Assulan on 4/27/2017.
 */
public class Challenge2_2 {
    // Return k-th to last element of a singly linked list
    // O(n)
    public static Node find(Node head, int k){
        int length = 0;
        if (head != null){
            // find tail
            Node current = head;
            while (current != null){
                current = current.next;
                length++;
            }
            // start from the head again and count length-k
            current = head;
            int count = 0;
            while (count != length-k-1 && current != null){
                current = current.next;
                count++;
            }
            return current;
        }
        return null;
    }

    // Recursive solution, O(n) time and O(n) space
    // Assume length of the list is known
    public static Node findRecursive(Node head, int k, int length){
        if (head == null) return null;
        else if (length-1 == k && length > 0){
            return head;
        }
        return findRecursive(head.next, k, length-1);
    }

    public static void main(String[] args){
        Node head = new Node(5);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(2);
        System.out.println(head);
        System.out.println(find(head, 0).data);
        System.out.println(findRecursive(head, 3, 4).data);
    }
}
