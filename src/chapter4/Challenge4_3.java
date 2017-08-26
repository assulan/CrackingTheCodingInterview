package chapter4;

import java.util.Arrays;

/**
 * Created by asus on 8/20/17.
 * Create a BST with min height from sorted (increasing order) array of unique integers.
 */
public class Challenge4_3 {

    // Construct BST of min height from sorted array
    public static BST minHeightBST(int[] arr){
        BST bst = new BST();
        bst.setRoot(helper(arr));
        return bst;
    }

    public static Node helper(int[] arr){
        int len = arr.length;
        if (len <= 0) return null;
        int value = arr[len/2];
        Node root = new Node(value);

        int leftEnd = len/2  < 0 ? 0 : len/2;
        Node left = helper(Arrays.copyOfRange(arr, 0, leftEnd));

        Node right = helper(Arrays.copyOfRange(arr, len/2+1, len));
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        BST bst = minHeightBST(arr);
        System.out.println(bst);
        System.out.println("Height of the BST: " + bst.height());
    }
}
