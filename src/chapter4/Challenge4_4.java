package chapter4;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by asus on 8/20/17.
 * Create a linked list of all nodes at each depth from a binary tree
 */
public class Challenge4_4 {
    public static List<Node>[] linkedLists(BST bst){
        List<Node>[] lists = new ArrayList[bst.height()];
        for(int i = 0; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }

        helper(bst.getRoot(), lists, 0);
        return lists;
    }

    public static List<Node>[] helper(Node root, List<Node>[] lists, int level){
        if (root == null) return lists;
        lists[level].add(root);
        helper(root.getLeft(), lists, level + 1);
        helper(root.getRight(), lists, level + 1);
        return lists;
    }

    public static List<List<Node>> linkedLists2(Node root){
        List<List<Node>> result = new ArrayList<>();
        List<Node> current = new ArrayList<>();
        if (root != null){
            current.add(root);
        }
        while (current.size() > 0){
            result.add(current);

            List<Node> parents = current;
            current = new ArrayList<>();
            for (Node p : parents){
                if (p.getLeft() != null) current.add(p.getLeft());
                if (p.getRight() != null) current.add(p.getRight());
            }
        }

        return result;
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
        for (List<Node> list : linkedLists(bst)){
            System.out.println(list);
        }
        System.out.println("--------------");
        for (List<Node> list : linkedLists2(bst.getRoot())){
            System.out.println(list);
        }

    }
}
