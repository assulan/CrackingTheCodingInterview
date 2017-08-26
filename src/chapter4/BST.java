package chapter4;

/**
 * Created by asus on 8/20/17.
 * Binary search tree
 */
public class BST {
    private Node root;
    private Node left;
    private Node right;

    public BST(){
        root = null;
        left = null;
        right = null;
    }

    public void insert(Node node){
        root = _insert(root, node);
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node r){
        root = r;
        left = r.getLeft();
        right = r.getRight();
    }

    private Node _insert(Node rootNode, Node node){
        if (rootNode == null) rootNode = node;
        else if (node.getData() > rootNode.getData()){
            // insert into right subtree
            rootNode.setRight(_insert(rootNode.getRight(), node));
        }
        else if (node.getData() <= rootNode.getData()){
            // insert into left subtree
            rootNode.setLeft(_insert(rootNode.getLeft(), node));
        }
        return rootNode;
    }

    public int height(){
        return _height(root);
    }

    private int _height(Node rootNode){
        if (rootNode == null) return 0;
        int left = _height(rootNode.getLeft());
        int right= _height(rootNode.getRight());
        return Math.max(left, right) + 1;
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
