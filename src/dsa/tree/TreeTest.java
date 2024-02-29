package src.dsa.tree;

import static src.dsa.tree.BinaryTree.*;

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

        //perfectly balanced 4 level tree
        Node balanced = getBalanced();
        printLeft(balanced, 1);
    }

    private static Node getBalanced() {
        Node root = new Node(10);
        root.setLeft(11);
        root.setRight(12);
        root.getLeft().setLeft(13);
        root.getLeft().setRight(14);
        root.getRight().setLeft(15);
        root.getRight().setRight(16);
        root.getLeft().getLeft().setLeft(17);
        root.getLeft().getLeft().setRight(18);
        root.getLeft().getRight().setLeft(19);
        root.getLeft().getRight().setRight(20);
        root.getRight().getLeft().setLeft(21);
        root.getRight().getLeft().setRight(22);
        root.getRight().getRight().setLeft(23);
        root.getRight().getRight().setRight(24);
        return root;
    }
}
