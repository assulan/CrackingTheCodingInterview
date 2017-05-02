package chapter2;

import java.util.Stack;

/**
 * Created by Assulan on 4/28/2017.
 */
public class Challenge2_7 {
    public static Node reverse(Node node){
        Node newNode = null;
        while (node != null){
            Node next = node.next;
            node.next = newNode;
            newNode = node;
            node = next;
        }
        return newNode;
    }

    // O(n) time and space
    // Create a reversed copy and compare it with the original list
    public static boolean isPalindrome(Node head){
        Node current = head;
        Node tail = reverse(head);
        while (current != null){
            if (current.data != tail.data) return false;
            current = current.next;
            tail = tail.next;
        }
        return true;
    }

    // Use slow and fast runner heads
    // Add elements of slow to the stack until fast hits the end of the linked list.
    // This means, we have reached the midpoitn. Now pop of the stack and compare with elements at slow head.
    public static boolean isPalindrome2(Node head){
        Node slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        // odd number of elements, skip the mid point
        if (fast != null) slow = slow.next;
        while (slow != null){
            int top = stack.pop().intValue();
            if (top != slow.data) return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.appendToTail(2); head.appendToTail(2); head.appendToTail(1);
        System.out.println(head);
        System.out.println(isPalindrome(head));
        Node notPalindrome = new Node(2);
        notPalindrome.appendToTail(3);
        System.out.println(notPalindrome);
        System.out.println(isPalindrome(notPalindrome));

        Node palindrome = new Node(1);
        palindrome.appendToTail(2);
        palindrome.appendToTail(1);
        System.out.println(palindrome);
        System.out.println(isPalindrome2(palindrome));
    }
}
