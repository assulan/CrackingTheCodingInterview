package chapter2;

/**
 * Created by Assulan on 4/27/2017.
 */
public class Challenge2_4 {
    // Partition singly linked list around value x such that all values less than x come before
    // and all values larger than x come after it.
    // O(n^2) time, O(n) space
    public static Node partition(Node head, int x){
        Node left = null, right = null, middle = null;
        Node current = head;
        while (current != null){
            if (current.data < x){
                // smaller values
                if (left == null)  left = new Node(current.data);
                else left.appendToTail(current.data);
            }
            else if (current.data == x){
                // midpoint
                if (middle == null) middle = new Node(current.data);
                else middle.appendToTail(current.data);
            }
            else if (current.data > x){
                // larger values
                if (right == null) right = new Node(current.data);
                else right.appendToTail(current.data);
            }
            current = current.next;
        }
        // merge the parts
        if (left != null) {
            head = left;
            // find the end of left
            while (left != null && left.next != null) left = left.next;
            if (left != null) left.next = middle;
            while (middle != null && middle.next != null) middle = middle.next;
            if (middle != null) middle.next = right;
        }
        return head;
    }

    // Partition in O(n) time
    public static Node partition2(Node head, int x){
        if (head == null) return null;
        Node left = null, right = null, middle = null, leftStart = null, rightStart = null, middleStart = null;
        Node current = head;
        while(current != null){
            if (current.data < x){
                if (left == null) {
                    left = current;
                    leftStart = left;
                }
                else {
                    left.next = current;
                    left = left.next;
                }
            }
            else if (current.data == x){
                if (middle == null) {
                    middle = current;
                    middleStart = middle;
                }
                else {
                    middle.next = current;
                    middle = middle.next;
                }
            }
            else if (current.data > x){
                if (right == null) {
                    right = current;
                    rightStart = right;
                }
                else {
                    right.next = current;
                    right = right.next;
                }
            }
            current = current.next;
        }
        if (leftStart != null){
            head = leftStart;
            left.next = middleStart;
            if (middle != null) middle.next = rightStart;
        }
        else if (middleStart != null){
            head = middleStart;
            middle.next = rightStart;
        }
        else if (rightStart != null){
            head = rightStart;
        }
        else head = null;
        return head;
    }

    // O(n) time with insertion in front
    // A little clearer than above
    public static Node partition3(Node head, int x){
        Node left = null;
        Node right = null;
        while (head != null){
            Node next = head.next;
            if (head.data < x){
                head.next = left;
                left = head;
            }
            else {
                head.next = right;
                right = head;
            }
            head = next;
        }
        // merge the linked lists
        if (left == null)return right;
        // find the end point of the left
        Node newHead = left;
        while(left.next != null) left = left.next;
        left.next = right;
        return newHead;
    }

    public static void main(String[] args){
        Node head = new Node(5);
        head.appendToTail(4);
        head.appendToTail(2);
        head.appendToTail(1);
        head.appendToTail(9);
        head.appendToTail(3);
        head.appendToTail(3);
        head.appendToTail(10);
        System.out.println(head);
        Node n = partition(head, 4);
        System.out.println(n);
        n = partition2(head, 4);
        System.out.println(n);

        Node list = new Node(5);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(2);
        list.appendToTail(7);
        System.out.println(list);
        n = partition3(list, 4);
        System.out.println(n);
    }
}
