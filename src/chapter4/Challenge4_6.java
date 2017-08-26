package chapter4;

/**
 * Created by asus on 8/20/17.
 * Return 'next' node in inorder traversal of a given node in BST.
 */
public class Challenge4_6 {
    // Return next node in inorder traversal of a given node
    public static NodeWithParent getNextNode(NodeWithParent node){
        if (node == null) return null;

        if (node.getRight() != null){
            // has a right subtree, return leftmost child.
            NodeWithParent child = node.getRight();
            while(child.getLeft() != null) child = child.getLeft();
            return child;
        }
        else {
            // does not have right subtree
            NodeWithParent parent = node.getParent();
            while (parent != null && node.getData() > parent.getData()){
                // while node is the right child of the parent
                node = node.getParent();
                parent = node.getParent();
            }
        }
        return node.getParent();

    }


    public static void main(String[] args){
        NodeWithParent root = new NodeWithParent(6);
        NodeWithParent l = new NodeWithParent(3);
        l.setParent(root);
        root.setLeft(l);

        NodeWithParent r = new NodeWithParent(8);
        r.setParent(root);
        root.setRight(r);

        NodeWithParent ll = new NodeWithParent(1);
        ll.setParent(l);
        l.setLeft(ll);

        NodeWithParent lr = new NodeWithParent(4);
        lr.setParent(l);
        l.setRight(lr);

        NodeWithParent rl = new NodeWithParent(7);
        rl.setParent(r);
        r.setLeft(rl);

        NodeWithParent rr = new NodeWithParent(10);
        rr.setParent(r);
        r.setRight(rr);

        System.out.println("Inorder traversal: 1 3 4 6 7 8 10");
        NodeWithParent node = l;
        System.out.println(String.format("Next node after: %s is %s", node, getNextNode(node)));

    }
}
