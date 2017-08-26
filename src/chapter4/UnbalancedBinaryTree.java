package chapter4;

/**
 * Created by asus on 8/19/17.
 */
public class UnbalancedBinaryTree {
    private Node root;

    public UnbalancedBinaryTree(){
        root = null;
    }

    public void addNode(int value){
        Node node = new Node(value);
        root = insert(root, node);
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node rootNode, Node node){
        if (rootNode == null){
            rootNode = node;
        }
        else if (Math.random() > 0.5){
            rootNode.setRight(insert(rootNode.getRight(), node));
        }
        else {
            rootNode.setLeft(insert(rootNode.getLeft(), node));
        }
        return rootNode;
    }

    private String spaces(int level){
        String str = "\n";
        for (int i = 0; i < level; i++)
            str += " ";
        return str;
    }

    private String str(Node node, int level){
        String retVal = "";
        if (node == null){
            return " ";
        }
        retVal = String.format("%s", node.getData());

        if (node.getLeft() != null){
            retVal += spaces(level+1) + "left:" + str(node.getLeft(), level + 1);
        }

        if (node.getRight() != null){
            retVal += spaces(level+1) + "right:" + str(node.getRight(), level + 1);
        }
        return retVal;
    }

    @Override
    public String toString() {
        Node current = root;
        return str(current, 0);
    }
}
