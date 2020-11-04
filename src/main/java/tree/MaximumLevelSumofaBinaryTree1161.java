package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = root.val;
        int result = 1;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            int sum = 0;
            for (int size = 0; size < currentSize; size++) {
                final TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
            ++level;
        }
        return result;
    }
}
