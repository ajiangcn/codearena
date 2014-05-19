package leetCode;

public class MaxPathSum {


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static class Answer {
        public int maxSum = 0;
        public boolean flag = false;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Answer a = new Answer();
        maxValue(root, a);
        return a.maxSum;
    }

    protected int maxValue(TreeNode root, Answer a) {
        if (root.left == null && root.right == null) {
            if (a.flag == false) {
                a.maxSum = root.val;
            } else if (root.val > a.maxSum){
                a.maxSum = root.val;
            }
            return root.val;
        } else if (root.left != null && root.right == null) {
            int lefMax = maxValue(root.left, a);
            int result = lefMax > 0 ? lefMax + root.val : root.val;
            if (result > a.maxSum) {
                a.maxSum = result;
            }
            return result;
        } else if (root.right != null && root.left == null) {
            int rightMax = maxValue(root.right, a);
            int result = rightMax > 0 ? rightMax + root.val : root.val;
            if (result > a.maxSum) {
                a.maxSum = result;
            }
            return result;
        } else {
            int leftMax = maxValue(root.left, a);
            int rightMax = maxValue(root.right, a);
            int c = leftMax > rightMax ? leftMax : rightMax;
            int d = leftMax > rightMax ? (rightMax > 0 ? rightMax : 0) : (leftMax > 0 ? leftMax : 0);
            int result = c > 0 ? c + root.val : root.val;
            if (d + result > a.maxSum) {
                a.maxSum = d + result;
            }
            return d + result;
        }
    }
}
