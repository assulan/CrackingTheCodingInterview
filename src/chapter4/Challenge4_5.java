package chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 8/20/17.
 * Return true if binary tree is a BST.
 */
public class Challenge4_5 {
    public static boolean isBST(Node root){
        if (root == null) return true;
        boolean left = true;
        boolean right = true;

        if (root.getLeft() != null){
            if (root.getData() < root.getLeft().getData()){
                return false;
            }
            left = isBST(root.getLeft());
        }

        if (root.getRight() != null){
            if (root.getData() >= root.getRight().getData()){
                return false;
            }
            right = isBST(root.getRight());
        }
        return left && right;
    }

    // Return list of inorder nodes
    public static List<Node> inorder(Node root, List<Node> nodes){
        if (root == null) return nodes;
        inorder(root.getLeft(), nodes);
        nodes.add(root);
        inorder(root.getRight(), nodes);
        return nodes;
    }

    // Return true if binary tree is a BST.
    // Assume all values are unique, and use inorder traversal of the tree.
    // The values in the inorder traversal have to be sorted.
    public static boolean isBST2(Node root){
        List<Node> inorderList = inorder(root, new ArrayList<>());
        for (int i = 1; i < inorderList.size(); i++){
            Node current = inorderList.get(i);
            Node previous = inorderList.get(i-1);
            if (current.getData() <= previous.getData()){
                return false;
            }
        }
        return true;
    }

    public static BST getBST(){
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
        return bst;
    }

    public static UnbalancedBinaryTree getBinaryTree(){
        UnbalancedBinaryTree tree = new UnbalancedBinaryTree();
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        return tree;
    }

    public static void main(String[] args){
        BST bst = getBST();
        UnbalancedBinaryTree binaryTree = getBinaryTree();

        System.out.println(bst);
        System.out.println("isBST: " + isBST(bst.getRoot()));
        System.out.println("-------------------");
        System.out.println(binaryTree);
        System.out.println("isBST: " + isBST(binaryTree.getRoot()));

        System.out.println("isBST2 :" + isBST2(bst.getRoot()));
        System.out.println("isBST2 :" + isBST2(binaryTree.getRoot()));
    }
}
