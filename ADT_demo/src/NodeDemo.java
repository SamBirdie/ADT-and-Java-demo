public class NodeDemo {
    private NodeDemo left, right;
    private Double element;

    public NodeDemo(Double element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public void setLeft(NodeDemo left) {
        this.left = left;
    }

    public void setRight(NodeDemo right) {
        this.right = right;
    }

    public NodeDemo getLeft() {
        return this.left;
    }
    public NodeDemo getRight() {
        return this.right;
    }

    public Double getElement() {
        return element;
    }
}
