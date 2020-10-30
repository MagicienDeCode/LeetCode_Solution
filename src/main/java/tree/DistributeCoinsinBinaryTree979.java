package tree;

public class DistributeCoinsinBinaryTree979 {
    int result = 0;

    public int distributeCoins(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        final int leftResult = dfs(node.left);
        final int rightResult = dfs(node.right);
        result += Math.abs(leftResult) + Math.abs(rightResult);
        return node.val + leftResult + rightResult - 1;
    }
}
