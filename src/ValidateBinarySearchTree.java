public class ValidateBinarySearchTree {


    //https://leetcode.com/problems/validate-binary-search-tree/
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

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root.left != null && !isValidBST(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return root.right == null || isValidBST(root.right);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        //root.right = new TreeNode(4);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(3);
        //root.right.right = new TreeNode(12);
        //root.right.left = new TreeNode(3);
        //printInorder(root);
        System.out.println(obj.isValidBST(root));
        //System.out.println("\n");
        //System.out.println(leftMismatch.val);
        //System.out.println(rightMismatch);
        printInorder(root);

    }

    static void printInorder(TreeNode node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }

}
