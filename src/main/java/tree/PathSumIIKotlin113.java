package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIIKotlin113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        final List<List<Integer>> results = new LinkedList<>();
        final List<Integer> subsets = new LinkedList<>();
        helperDfs(root, 0, sum, subsets, results);
        return results;
    }

    private void helperDfs(
            TreeNode root,
            int current,
            int sum,
            List<Integer> subsets,
            List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        subsets.add(root.val);
        final int currentSum = current + root.val;
        if (root.left == null && root.right == null) {
            if (currentSum == sum) {
                results.add(new ArrayList<>(subsets));
            }
            subsets.remove(subsets.size() - 1);
            return;
        }
        helperDfs(root.left, currentSum, sum, subsets, results);
        helperDfs(root.right, currentSum, sum, subsets, results);
        subsets.remove(subsets.size() - 1);
    }
}
