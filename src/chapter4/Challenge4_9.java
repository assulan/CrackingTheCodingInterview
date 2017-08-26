package chapter4;

/**
 * Created by asus on 8/26/17.
 * Given a binary tree print all paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf.
 */
public class Challenge4_9 {
    public static int height(Node root){
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    // Finds and prints paths in the tree denoted by root node such that
    // values in the path sum up to sum.
    // level denotes the root node level in the tree.
    // Idea: backtrack from the current node towards root and sum the values along the way.
    //       As soon as the values sum up to sum, print the path.
    public static void findSum(Node root, int sum, int[] path, int level){
        if (root == null) return;

        path[level] = root.getData();

        int t = 0; // keep track of current sum
        for (int i = level; i >= 0; i--){
            t += path[i];
            if (t == sum) printPath(i, level, path); // print the found path
        }

        // Look for other paths in left and right subtrees
        findSum(root.getLeft(), sum, path, level + 1);
        findSum(root.getRight(), sum, path, level + 1);
    }

    // Prints the path that starting from the start level until end level.
    public static void printPath(int start, int end, int[] path){
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end; i++){
            builder.append(String.valueOf(path[i]));
            if (i != end)
                builder.append("-->");
        }
        System.out.println(builder.toString());
    }

    public static void findSum(Node root, int sum){
        int height = height(root);
        int[] path = new int[height]; // placeholder for values in the paths
        findSum(root, sum, path, 0);
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

        findSum(bst.getRoot(), 12);
    }
}
