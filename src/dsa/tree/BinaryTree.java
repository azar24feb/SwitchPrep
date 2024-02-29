package src.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    /**
     * Print the left view of the BT
     *
     * @param root  root node
     * @param level next level
     */
    static int maxLevel = 0;
    public static void printLeft(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level){
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        printLeft(root.right, level + 1);
        printLeft(root.left, level + 1);
    }

    /**
     * Find Max in BT
     *
     * @param root root of BT
     * @return max value in BT
     */
    public static int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Integer.max(root.data, Integer.max(getMax(root.left), getMax(root.right)));
        }
    }

    public static int getSizeIterative(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            count++;
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
        return count;
    }

    /**
     * Size of the BinaryTree
     */
    public static int getSize(Node root) {
        if (root == null) {
            return 0;
        } else {
            return getSize(root.left) + getSize(root.right) + 1;
        }
    }

    /**
     * Level Order Traversal Line by Line Method 2
     * Here you run two loops, 2nd loop runs for each level
     *
     * @param root pass the root node
     */
    public static void printLevelOrdeLineByLine2(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            System.out.println();
        }

    }

    /**
     * Level Order Traversal Line by Line Method 1
     * Here you insert a null after each level is complete
     *
     * @param root pass the root node
     */
    public static void printLevelOrdeLineByLine(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); //end of level marker
        while (q.size() > 1) {
            Node curr = q.poll();
            //check if current is null, that means you are at the end of the level,
            // then insert another null, because while coming to the end of the level,
            // you already enqueued all elements of next level
            if (curr == null) {
                System.out.println();
                q.add(null);
            } else {
                System.out.printf(curr.data + " ");
                if (curr.getLeft() != null)
                    q.add(curr.left);
                if (curr.getRight() != null)
                    q.add(curr.right);
            }
        }
    }

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
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.data);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }
}
