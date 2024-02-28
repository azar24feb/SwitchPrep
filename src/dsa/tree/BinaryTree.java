package src.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
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
public class BinaryTree {
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public static int height(Node root) {
        if (root != null) {
            return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        } else
            return 0;
    }

    public static void printK(Node root, int k) {
        if (root == null) return;
        else if (k == 0) {
            System.out.println(root.getData());
        } else {
            printK(root.left, k - 1);
            printK(root.right, k - 1);
        }
    }

    /**
     * this method finds height, and then runs loop from 0 to height and prints at a distance i
     * this has TC = O(h * n)
     *
     * @param root
     */
    public static void breadthFirstTraversal(Node root) {
        int k = BinaryTree.height(root);
        for (int i = 0; i < k; i++) {
            printK(root, i);
        }
    }

    /**
     * O(n) solution for BF Traversal or Level Order Traversalc
     * Use Queue DS
     */
    public static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.poll();
            System.out.println(cur.data);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }


    }
}
