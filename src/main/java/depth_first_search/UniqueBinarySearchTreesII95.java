package depth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        final List<TreeNode> result = new ArrayList<>();
        if (left > right) {
            result.add(null);
            return result;
        }
        for (int index = left; index <= right; index++) {
            final List<TreeNode> leftResult = dfs(left, index - 1);
            final List<TreeNode> rightResult = dfs(index + 1, right);
            for (TreeNode leftNode : leftResult) {
                for (TreeNode rightNode : rightResult) {
                    final TreeNode root = new TreeNode(index);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static class TreeNode {
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
