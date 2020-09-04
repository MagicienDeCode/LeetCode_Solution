package tree;

public class BinaryTreeMaximumPathSum124 {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftResult = Math.max(0, dfs(root.left));
        final int rightResult = Math.max(0, dfs(root.right));
        result = Math.max(result, leftResult + rightResult + root.val);
        return Math.max(leftResult, rightResult) + root.val;
    }
}
