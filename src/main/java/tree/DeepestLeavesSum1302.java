package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            int currentSum = 0;
            for (int size = 0; size < currentSize; size++) {
                final TreeNode node = queue.poll();
                currentSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            sum = currentSum;
        }
        return sum;
    }
}
