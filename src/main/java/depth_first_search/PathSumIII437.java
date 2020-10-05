package depth_first_search;

public class PathSumIII437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum, 0) +  // the path go through the root
                pathSum(root.right, sum) +  // recursion for left subtrees
                pathSum(root.left, sum);
    }

    private int dfs(TreeNode root, int sum, int pre) {
        if (root == null) {
            return 0;
        }
        final int current = pre + root.val;
        final int result = current == sum ? 1 : 0;
        return dfs(root.left, sum, current) +
                dfs(root.right, sum, current) +
                result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
