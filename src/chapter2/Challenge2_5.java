package chapter2;

/**
 * Created by Assulan on 4/28/2017.
 */
public class Challenge2_5 {
    // Return the list that is sum of 2 lists
    // E.g. 7->1->6 + 5->9->2 = 2->1->9
    // O(n) time, O(n) space
    // Assume the lists are of the same length
    public static Node add(Node n1, Node n2){
        int carry = 0, sum = 0;
        Node result = null;
        while (n1 != null){
            sum = n1.data + n2.data + carry;
            if (result == null) {
                result = new Node(sum%10);
            }
            else {
                result.appendToTail(sum%10);
            }
            carry = sum / 10;
            n1 = n1.next;
            n2 = n2.next;
        }
        return result;
    }

    // Assume lists have different size
    public static Node add2(Node n1, Node n2){
        // find out longer list size
        int length = n1.size() > n2.size() ? n1.size() : n2.size();
        Node result = null;
        int carry = 0;
        while (length-- != 0){
            int data1 = n1 == null ? 0 : n1.data;
            int data2 = n2 == null ? 0 : n2.data;
            int sum = data1 + data2 + carry;
            if (result == null) result = new Node(sum % 10);
            else result.appendToTail(sum % 10);
            carry = sum / 10;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        return result;
    }

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

    // The lists are stored in forward order
    // E.g. 6->1->7 + 2->9->5 = 9->1->2
    // Idea: reverse the lists, re-use previous add method, reverse the result
    public static Node add3(Node n1, Node n2){
        n1 = reverse(n1);
        n2 = reverse(n2);
        return reverse(add2(n1, n2));
    }

    public static void main(String[] args){
        Node n1 = new Node(7);
        n1.appendToTail(1);
        n1.appendToTail(6);

        Node n2 = new Node(5);
        n2.appendToTail(9);
        n2.appendToTail(2);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(add(n1, n2));
        n1.appendToTail(7);
        System.out.println(add2(n1, n2));

        Node n3 = new Node(6);
        n3.appendToTail(1); n3.appendToTail(7);
        Node n4 = new Node(2); n4.appendToTail(9); n4.appendToTail(5);
        System.out.println( n3 + " " + n4 + " = " + add3(n3,n4) );
    }
}
