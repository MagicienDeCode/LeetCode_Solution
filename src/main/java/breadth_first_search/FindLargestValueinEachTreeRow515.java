package breadth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 1. create a queue FIFO, then put root in it
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        // 2. while queue is not null, take itself add its children
        while (!treeNodeQueue.isEmpty()) {
            final int currentSize = treeNodeQueue.size();
            int currentLevel = Integer.MIN_VALUE;
            for (int i = 0; i < currentSize; i++) {
                final TreeNode treeNode = treeNodeQueue.poll();
                currentLevel = Math.max(currentLevel, treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.offer(treeNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public class TreeNode {
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
