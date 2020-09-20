package tree;

public class BinaryTreeTilt563 {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftVal = dfs(root.left);
        final int rightVal = dfs(root.right);
        sum += Math.abs(leftVal - rightVal);
        return leftVal + rightVal + root.val;
    }
}
