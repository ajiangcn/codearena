package leetCode;

/**
 * Created by youjiang on 3/17/14.
 */
public class SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
        TreeNode(int x, TreeNode l, TreeNode r) {val = x; left = l; right = r;}
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
