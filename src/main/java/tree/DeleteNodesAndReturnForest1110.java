package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DeleteNodesAndReturnForest1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        final List<TreeNode> results = new LinkedList<>();
        final HashSet<Integer> set = new HashSet<>();
        for (int d : toDelete) {
            set.add(d);
        }
        final TreeNode newRoot = dfs(root, set, results);
        if (newRoot != null) {
            results.add(newRoot);
        }
        return results;
    }

    private TreeNode dfs(TreeNode root, HashSet<Integer> set, List<TreeNode> results) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, set, results);
        root.right = dfs(root.right, set, results);

        if (set.contains(root.val)) {
            if (root.left != null) {
                results.add(root.left);
            }
            if (root.right != null) {
                results.add(root.right);
            }
            return null;
        }

        return root;
    }
}
