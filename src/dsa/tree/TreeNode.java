package src.dsa.tree;

public class TreeNode {
    private int key;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getKey());
            inOrder(root.getRight());
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getKey());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getKey());
        }
    }

    public static int height(TreeNode root) {
        if (root != null) {
            return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        } else
            return 0;
    }

    public static void printK(TreeNode root, int k) {
        if (root == null) return;
        else if (k == 0) {
            System.out.println(root.getKey());
        } else {
            printK(root.left, k - 1);
            printK(root.right, k - 1);
        }
    }

    public static void breadthFirstTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root.getKey());
        breadthFirstTraversal(root.getLeft());
        breadthFirstTraversal(root.getRight());
    }
}
