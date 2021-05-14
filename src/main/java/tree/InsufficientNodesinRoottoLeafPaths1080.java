package tree;

public class InsufficientNodesinRoottoLeafPaths1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, limit, 0);
    }

    private TreeNode dfs(TreeNode current, int limit, int sum) {
        sum += current.val;
        // if leaf node
        if (current.left == null && current.right == null) {
            if (sum < limit) {
                return null;
            } else {
                return current;
            }
        }
        // dfs to solve left and right branches
        if (current.left != null) {
            current.left = dfs(current.left, limit, sum);
        }
        if (current.right != null) {
            current.right = dfs(current.right, limit, sum);
        }
        // after dfs, if current node becomes leaf, return null
        if (current.left == null && current.right == null) {
            return null;
        }
        return current;
    }
}
