package chapter4;

/**
 * Created by asus on 8/20/17.
 * Find the first common ancestor of 2 nodes in a binary tree (not necessarily a BST).
 */
public class Challenge4_7 {

    // Calculate the height of the node relative to the root of the tree.
    public static int height(NodeWithParent root, int counter){
        if (root == null) return 0;
        else if (root.getParent() == null){
            // reached the top of the tree
            return counter;
        }
        return height(root.getParent(), counter + 1);
    }

    // Return common ancestor assuming nodes have links to parent nodes.
    public static NodeWithParent commonAncestor(NodeWithParent node1, NodeWithParent node2){
        if (node1 != null && node2 != null){
            if (node1.getParent() == node2.getParent()){
                return node1.getParent();
            }

            // Calculate height of each node
            int h1 = height(node1, 0);
            int h2 = height(node2, 0);

            if (h1 == h2){
                // move both up until common ancestor
                while (node1.getParent() != node2.getParent()){
                    node1 = node1.getParent();
                    node2 = node2.getParent();
                }
            }
            else if (h1 < h2){
                // If heights are different, move up the deeper node.
                // move up node2
                if (h1 == 0) return node1; // node1 is root
                while (node1.getParent() != node2.getParent()) node2 = node2.getParent();
            }
            else {
                // move up node1
                if (h2 == 0) return node2; // node2 is root
                while (node1.getParent() != node2.getParent()) node1 = node1.getParent();
            }
            return node1.getParent();

        }
        else return null;
    }

    // Return true if node is descendant of root.
    public static boolean covers(NodeWithParent root, NodeWithParent node){
        if (root == null) return false;
        else if (root == node) return true;
        return covers(root.getLeft(), node) || covers(root.getRight(), node);
    }

    // Common ancestor without using parent links.
    // Assume tree root is available
    // If nodes are on different sides --> current root is ancestor.
    public static NodeWithParent commonAncestor2(NodeWithParent root, NodeWithParent n1, NodeWithParent n2){
        if (root == null) return null;
        else if (!covers(root, n1) || !covers(root, n2)) return null;
        else if (root == n1 || root == n2) return root;

        boolean isLeft = covers(root.getLeft(), n1);  // is n1 on the left?
        boolean isRight =covers(root.getRight(), n2); // is n2 on the right?

        if (isLeft && isRight) return root; // n1 and n2 on different sides of the root.
        NodeWithParent childSide = isLeft ? root.getLeft() : root.getRight();
        return commonAncestor2(childSide, n1, n2);
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
        NodeWithParent node1 = null;
        NodeWithParent node2 = root;
//        NodeWithParent ancestor = commonAncestor(node1, node2);
        NodeWithParent ancestor = commonAncestor2(root, node1, node2);
        System.out.println(String.format("Common ancestor of %s and %s is %s", node1, node2, ancestor));
    }
}
