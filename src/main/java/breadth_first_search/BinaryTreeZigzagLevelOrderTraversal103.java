package breadth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            final List<Integer> levelResult = new LinkedList<>();
            final int currentSize = queue.size();
            for (int index = 1; index <= currentSize; index++) {
                final TreeNode treeNode = queue.poll();
                if (flag) {
                    levelResult.add(0, treeNode.val);
                } else {
                    levelResult.add(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            flag = !flag;
            result.add(levelResult);
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
