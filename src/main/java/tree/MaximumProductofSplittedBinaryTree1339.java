package tree;

public class MaximumProductofSplittedBinaryTree1339 {

    private static final long MOD = 1000000007;

    private long max = 0;

    private long sum = 0;

    public int maxProduct(TreeNode root) {
        sum = calculateSum(root);
        dfs(root);
        return (int) (max % MOD);
    }

    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final long currentSum = root.val + dfs(root.left) + dfs(root.right);
        max = Math.max(max, currentSum * (sum - currentSum));
        return currentSum;
    }

    private long calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + calculateSum(root.left) + calculateSum(root.right);
    }
}
