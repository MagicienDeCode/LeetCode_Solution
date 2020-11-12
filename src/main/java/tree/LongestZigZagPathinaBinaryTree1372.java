package tree;

public class LongestZigZagPathinaBinaryTree1372 {

    private int max;

    public int longestZigZag(TreeNode root) {
        max = 1;
        dfs(root);
        return max - 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        final int[] leftResult = dfs(root.left);
        final int[] rightResult = dfs(root.right);

        final int leftMax = 1 + leftResult[1];
        final int rightMax = 1 + rightResult[0];

        max = Math.max(max, leftMax);
        max = Math.max(max, rightMax);

        return new int[]{leftMax, rightMax};
    }
}
