package tree;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }

    private boolean helper(TreeNode root, int current, int sum) {
        if (root == null) {
            return false;
        }
        final int currentSum = current + root.val;
        if (root.left == null && root.right == null) {
            return currentSum == sum;
        }
        return helper(root.left, currentSum, sum) ||
                helper(root.right, currentSum, sum);
    }
}
