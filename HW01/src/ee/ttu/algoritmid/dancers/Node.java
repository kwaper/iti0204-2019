package ee.ttu.algoritmid.dancers;

public class Node {

    private Dancer dancer;
    private Node left;
    private Node right;
    private Node parent;

    //root
    public Node(Dancer dancer, Node left, Node right) {
        this.dancer = dancer;
        this.left = left;
        this.right = right;
        this.parent = null;
    }

    public Dancer getDancer() {
        return dancer;
    }

    public void setLeft(Node left) {
        this.left = left;
        if (left != null){
            left.setParent(this);
        }
    }

    public void setRight(Node right) {
        this.right = right;
        if (right != null){
            right.setParent(this);
        }
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public void deleteLeftChild(){
        this.left = null;
    }

    public void deleteRightChild(){
        this.right = null;
    }

    public void deleteParent(){
        this.parent = null;
    }

    public void setDancer(Dancer dancer) {
        this.dancer = dancer;
    }
}
