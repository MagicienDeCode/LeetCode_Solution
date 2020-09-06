package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> results = new LinkedList<>();
        final List<String> subsets = new ArrayList<>();
        dfs(root, subsets, results);
        return results;
    }

    private void dfs(
            TreeNode root,
            List<String> subsets,
            List<String> results
    ) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            subsets.add(root.val + "");
            final StringBuilder sb = new StringBuilder();
            for (String s : subsets) {
                sb.append(s);
            }
            results.add(sb.toString());
        } else {
            subsets.add(root.val + "->");
            dfs(root.left, subsets, results);
            dfs(root.right, subsets, results);
        }
        subsets.remove(subsets.size() - 1);
    }
}
