package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue513 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 1. create a queue FIFO, then put root in it
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        int result = 0;

        // 2. while queue is not null, take itself add its children
        while (!treeNodeQueue.isEmpty()) {
            final int currentSize = treeNodeQueue.size();
            for (int i = 0; i < currentSize; i++) {
                final TreeNode treeNode = treeNodeQueue.poll();
                if (i == 0) {
                    result = treeNode.val;
                }
                if (treeNode.left != null) {
                    treeNodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.offer(treeNode.right);
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
