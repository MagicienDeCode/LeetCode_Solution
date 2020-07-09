package breadth_first_search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class MaximumWidthofBinaryTree662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        int result = 1;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                final Pair<TreeNode, Integer> current = queue.poll();
                final TreeNode currentNode = current.getKey();
                if (currentNode.left != null) {
                    queue.offer(new Pair<>(currentNode.left, 2));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair<>(currentNode.right, 3));
                }
            } else {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                final int currentSize = queue.size();
                for (int index = 0; index < currentSize; index++) {
                    final Pair<TreeNode, Integer> current = queue.poll();
                    final TreeNode currentNode = current.getKey();
                    final int value = current.getValue();
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                    if (currentNode.left != null) {
                        queue.offer(new Pair<>(currentNode.left, value << 1));
                    }
                    if (currentNode.right != null) {
                        queue.offer(new Pair<>(currentNode.right, value * 2 + 1));
                    }
                }
                result = Math.max(result, max - min + 1);
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