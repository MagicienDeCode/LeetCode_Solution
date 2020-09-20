package tree;

public class DiameterofBinaryTree543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max == 0 ? 0 : max - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftResult = dfs(root.left);
        final int rightResult = dfs(root.right);
        max = Math.max(max, leftResult + rightResult + 1);
        return Math.max(leftResult, rightResult) + 1;
    }
}
