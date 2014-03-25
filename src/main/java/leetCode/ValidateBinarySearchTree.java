package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youjiang on 3/18/14.
 */
public class ValidateBinarySearchTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
        TreeNode(int x, TreeNode l, TreeNode r) {val = x; left = l; right = r;}
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderTra = new ArrayList<Integer>();
        //in order traverse
        inOrderTraverse(root, inOrderTra);
        if(inOrderTra.size() <= 1) {
            return true;
        }
        for (int i=1; i<inOrderTra.size(); i++) {
            if(inOrderTra.get(i) <= inOrderTra.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrderTraverse(TreeNode node, List<Integer> inOrderTra) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                inOrderTra.add(node.val);
            } else {
                inOrderTraverse(node.left, inOrderTra);
                inOrderTra.add(node.val);
                inOrderTraverse(node.right, inOrderTra);
            }
        }
    }
}
