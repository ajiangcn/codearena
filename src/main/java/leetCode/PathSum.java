package leetCode;

import java.util.ArrayList;

public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x;}

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> partials = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        hasPathSum(root, sum, partials, results);
        return results;
    }

    protected void hasPathSum(TreeNode root, int sum,
                              ArrayList<Integer> partials,
                              ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }

        partials.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<Integer>(partials));
            }
        }
        hasPathSum(root.left, sum-root.val, partials, result);
        hasPathSum(root.right, sum-root.val, partials, result);
        partials.remove(partials.size()-1);
    }

}
