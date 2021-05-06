public class RecoverBinarySearchTree {


    //https://leetcode.com/problems/recover-binary-search-tree/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static TreeNode leftMismatch = null;
    static TreeNode rightMismatch = null;
    static TreeNode prev = null;
    static TreeNode mid = null;

    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = leftMismatch.val;
        if (rightMismatch == null) {
            leftMismatch.val = mid.val;
            mid.val = temp;
        } else {
            leftMismatch.val = rightMismatch.val;
            rightMismatch.val = temp;
        }
    }

    public static void traverse(TreeNode node) {
        if (node.left != null) {
            traverse(node.left);
        }
        if (prev != null && prev.val > node.val) {
            if (leftMismatch == null) {
                leftMismatch = prev;
                mid = node;
                //System.out.println("Prev" + prev.val);
                //System.out.println("Node" + node.val);
            } else {
                rightMismatch = node;
                mid = prev;
            }
        }
        prev = node;
        if (node.right != null) traverse(node.right);
    }

    static void printInorder(TreeNode node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(3);
        //root.right.right = new TreeNode(12);
        root.right.left = new TreeNode(2);
        //printInorder(root);
        recoverTree(root);
        //System.out.println("\n");
        //System.out.println(leftMismatch.val);
        //System.out.println(rightMismatch);
        printInorder(root);
    }
}
