package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int index = 1; index <= currentSize; index++) {
                final TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return count;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            ++count;
        }
        return count;
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
