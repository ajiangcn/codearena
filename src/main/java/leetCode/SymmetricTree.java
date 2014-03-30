package leetCode;

public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(compare(root.left, root.right)) {
            return true;
        }
        return false;
    }

    boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;

        if(left.val == right.val &&
                compare(left.left, right.right) &&
                compare(left.right, right.left)) {
            return true;
        }
        return false;
    }

}
