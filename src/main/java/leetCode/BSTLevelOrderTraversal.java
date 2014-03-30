package leetCode;

import java.util.ArrayList;

public class BSTLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {this.val = x;}
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<TreeNode> remainings = new ArrayList<TreeNode>();
        remainings.add(root);
        while(remainings.size() > 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            ArrayList<TreeNode> newRemainings = new ArrayList<TreeNode>();
            for(TreeNode n : remainings) {
                level.add(n.val);
                if(n.left != null) {
                    newRemainings.add(n.left);
                }
                if(n.right != null) {
                    newRemainings.add(n.right);
                }
            }
            remainings = newRemainings;
            result.add(level);
        }
        return result;
    }

}
