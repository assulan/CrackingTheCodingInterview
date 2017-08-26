package chapter4;

/**
 * Created by asus on 8/26/17.
 * Given two large binary trees: T1 with millions of nodes, T2 with hundreds of nodes, write
 * an algorithm to decide if T2 is a subtree of T1.
 * Subtrees have to be exact.
 */
public class Challenge4_8 {
    // Return in-order traversal of the tree as string
    // Replace null values with 'null'.
    public static String inOrder(Node root){
        if (root == null) return "null";
        return inOrder(root.getLeft()) + root + inOrder(root.getRight());
    }

    // Return true if t2 is a subtree of t1
    // t2 is a subtree if its in-order travels in a substring of t1's inorder traversal.
    // Problem: memory inefficient for large trees.
    // O(n + m) memory & time, where n and m are number of nodes in T1 and T2.
    public static boolean isSubtree(Node t1, Node t2){
        String inorderT1 = inOrder(t1);
        String inorderT2 = inOrder(t2);
        return inorderT1.endsWith(inorderT2) || inorderT1.startsWith(inorderT2);
    }

    // Return true if t2 is a subtree of t1.
    // Traverse t1 and if a node is equal to t2.root compare the subtree of t1 with t2.
    // O(n + km) time, where n = nodes in T1, m = nodes in T2, k = # of occurences of t2.root in t1.
    // O(logn + logm) memory
    public static boolean isSubtree2(Node t1, Node t2){
        if (t2 == null) return true; // the empty tree is always a subtree
        if (t1 == null) return false; // the big tree is empty
        return subTree(t1, t2);
    }

    // Helper for isSubtree2
    public static boolean subTree(Node t1, Node t2){
        if (t1 == null) return false; // larger tree is empty
        if (t1.getData() == t2.getData()){
            // the node values match
            if (matchTree(t1, t2)) return true;
        }
        return subTree(t1.getLeft(), t2) || subTree(t1.getRight(), t2);
    }

    // Helper for subTree
    public static boolean matchTree(Node t1, Node t2){
        if (t1 == null && t2 == null) return true; // both trees are empty
        if (t1 == null || t2 == null) return false; // one is empty
        if (t1.getData() != t2.getData()) return false; // do not match
        return matchTree(t1.getLeft(), t2.getLeft())
                && matchTree(t1.getRight(), t2.getRight());
    }

    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(new Node(6));
        bst.insert(new Node(3));
        bst.insert(new Node(9));
        bst.insert(new Node(8));
        bst.insert(new Node(7));
        bst.insert(new Node(10));
        bst.insert(new Node(2));
        bst.insert(new Node(5));
        bst.insert(new Node(1));
        bst.insert(new Node(4));
        bst.insert(new Node(12));
        bst.insert(new Node(11));
        System.out.println(bst);

        BST bst2 = new BST();
        bst2.insert(new Node(9));
        bst2.insert(new Node(8));
        bst2.insert(new Node(7));
        bst2.insert(new Node(10));
        bst2.insert(new Node(12));
        bst2.insert(new Node(11));
//        bst2.insert(new Node(2));
        System.out.println(bst2);
        System.out.println(inOrder(bst.getRoot()));
        System.out.println(inOrder(bst2.getRoot()));

        System.out.println("Is subtree: " + isSubtree(bst.getRoot(), bst2.getRoot()));
        System.out.println("Is subtree2: " + isSubtree2(bst.getRoot(), bst2.getRoot()));
    }
}
