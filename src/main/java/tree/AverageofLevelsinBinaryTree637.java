package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree637 {
    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final List<Integer> levelValues = new ArrayList<>();
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(levelValues.stream().mapToDouble(i -> i).average().orElse(0));
        }
        return results;
    }
}
