package tree;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        final HashMap<Integer, Integer> results = new HashMap<>();
        dfs(root, results);

        final int maxCount = results.values().stream().reduce(Math::max).orElse(-1);

        return results.entrySet()
                .stream()
                .filter(it -> it.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int dfs(TreeNode root, HashMap<Integer, Integer> results) {
        if (root == null) {
            return 0;
        }
        final int leftResult = dfs(root.left, results);
        final int rightResult = dfs(root.right, results);

        final int sum = root.val + leftResult + rightResult;
        results.put(sum, 1 + results.getOrDefault(sum, 0));
        return sum;
    }
}
