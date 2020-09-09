package tree;

public class HouseRobberIII337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int[] results = dfs(root);
        return Math.max(results[0], results[1]);
    }

    /*
    results[0] : take current node value
    results[1] : do not take current, but take child nodes' values
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{root.val, 0};
        }
        final int[] leftResults = dfs(root.left);
        final int[] rightResults = dfs(root.right);
        final int[] results = new int[2];
        // take current, so we can't take child nodes' values
        results[0] = root.val + leftResults[1] + rightResults[1];
        // do not take current, take max of left/right
        results[1] = Math.max(leftResults[0], leftResults[1]) +
                Math.max(rightResults[0], rightResults[1]);
        return results;
    }
}
