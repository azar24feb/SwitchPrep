package src.dsa.tree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = new Node(left);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = new Node(right);
    }
}
