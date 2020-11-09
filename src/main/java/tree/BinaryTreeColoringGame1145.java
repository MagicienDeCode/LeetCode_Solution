package tree;

public class BinaryTreeColoringGame1145 {
    int maxBlue;
    int total;
    int xVal;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        maxBlue = 0;
        total = n;
        xVal = x;
        dfs(root);
        return maxBlue > (total >> 1);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftCount = dfs(root.left);
        final int rightCount = dfs(root.right);
        if (root.val == xVal) {
            maxBlue = Math.max(maxBlue, leftCount);
            maxBlue = Math.max(maxBlue, rightCount);
            maxBlue = Math.max(maxBlue, total - leftCount - rightCount - 1);
        }
        return leftCount + rightCount + 1;
    }
}
