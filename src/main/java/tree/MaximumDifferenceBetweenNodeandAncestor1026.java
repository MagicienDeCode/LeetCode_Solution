package tree;

public class MaximumDifferenceBetweenNodeandAncestor1026 {
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        final int[] leftResult = dfs(root.left);
        final int[] rightResult = dfs(root.right);
        final int max = Math.max(leftResult[1], rightResult[1]);
        if (max != -1) {
            result = Math.max(result, Math.abs(max - root.val));
        }
        final int min;
        if (leftResult[0] == -1) {
            min = rightResult[0];
        } else if (rightResult[0] == -1) {
            min = leftResult[0];
        } else {
            min = Math.min(leftResult[0], rightResult[0]);
        }
        if (min != -1) {
            result = Math.max(result, Math.abs(min - root.val));
        }
        return new int[]{min == -1 ? root.val : Math.min(root.val, min), Math.max(root.val, max)};
    }
}
