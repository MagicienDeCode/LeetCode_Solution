package tree;

public class LongestUnivaluePath687 {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftResult = dfs(root.left);
        final int rightResult = dfs(root.right);

        if (root.left != null &&
                root.right != null &&
                root.val == root.left.val &&
                root.val == root.right.val) {
            max = Math.max(max, 2 + leftResult + rightResult);
            return 1 + Math.max(leftResult, rightResult);
        } else if (root.left != null && root.val == root.left.val) {
            max = Math.max(max, 1 + leftResult);
            return 1 + leftResult;
        } else if (root.right != null && root.val == root.right.val) {
            max = Math.max(max, 1 + rightResult);
            return 1 + rightResult;
        } else {
            return 0;
        }
    }
}
