package src.dsa.tree;

public class TreeTest {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(20);
        root.setRight(30);
        root.getLeft().setLeft(8);
        root.getLeft().setRight(7);
        root.getRight().setRight(6);
        root.getLeft().getRight().setLeft(9);
        root.getLeft().getRight().setRight(15);
        BinaryTree.printLevelOrder(root);
    }
}
