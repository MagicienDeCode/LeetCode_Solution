package tree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            final TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = d;
        while (!queue.isEmpty()) {
            if (--currentDepth == 1) {
                break;
            }
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        // now in queue is the level we should handle
        while (!queue.isEmpty()) {
            final TreeNode current = queue.poll();
            final TreeNode left = current.left;
            final TreeNode right = current.right;
            current.left = new TreeNode(v);
            current.right = new TreeNode(v);
            current.left.left = left;
            current.right.right = right;
        }
        return root;
    }
}
