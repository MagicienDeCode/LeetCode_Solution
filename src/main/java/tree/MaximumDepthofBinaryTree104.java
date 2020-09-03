package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ++level;
        }
        return level;
    }
}
