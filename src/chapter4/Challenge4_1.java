package chapter4;

/**
 * Created by asus on 8/19/17.
 * Check if a binary tree is balanced (i.e. height of subtrees never differ by more than 1)
 */
public class Challenge4_1 {
    // Return tree height
    public static int height(Node root){
        if (root == null) return 0;
        int left = height(root.getLeft());
        int right = height(root.getRight());
        return Math.max(left, right) + 1;
    }

    // Return false if height difference of 2 subtrees of any node > 1.
    // O(nlogn)
    public static boolean isBalanced(Node root){
        if (root == null) return true;
        int diff = height(root.getLeft()) - height(root.getRight());
        if (Math.abs(diff) > 1){
            return false;
        }
        else{
            return isBalanced(root.getLeft()) && isBalanced(root.getRight());
        }
    }

    // Return height if balanced tree, and -1 if not.
    public static int checkHeight(Node root){
        if (root == null) return  0;
        int left = checkHeight(root.getLeft());
        if (left == -1) return -1;
        int right = checkHeight(root.getRight());
        if (right == -1) return -1;

        // Check the absolute difference
        int diff = Math.abs(left - right);
        if (diff > 1) return -1;
        else return Math.max(left, right) + 1;
    }

    // Return true if the tree is balanced, false otherwise.
    // O(n) time, O(h) space (h = height).
    public static boolean isBalanced2(Node root){
        if (checkHeight(root) == -1) return false;
        return true;
    }

    public static void main(String[] args){
        UnbalancedBinaryTree tree = new UnbalancedBinaryTree();
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        System.out.println(tree);
        System.out.println(height(tree.getRoot()));
        System.out.println("Is balanced: " + isBalanced(tree.getRoot()));
        System.out.println("Is balanced2: " + isBalanced2(tree.getRoot()));
    }
}

