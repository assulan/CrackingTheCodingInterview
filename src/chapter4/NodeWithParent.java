package chapter4;

/**
 * Created by asus on 8/20/17.
 */
public class NodeWithParent {
    private int data;
    private NodeWithParent left;
    private NodeWithParent right;
    private NodeWithParent parent;

    public NodeWithParent(int d){
        data = d;
        parent = null;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeWithParent getLeft() {
        return left;
    }

    public void setLeft(NodeWithParent left) {
        this.left = left;
    }

    public NodeWithParent getRight() {
        return right;
    }

    public void setRight(NodeWithParent right) {
        this.right = right;
    }

    public NodeWithParent getParent() {
        return parent;
    }

    public void setParent(NodeWithParent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
