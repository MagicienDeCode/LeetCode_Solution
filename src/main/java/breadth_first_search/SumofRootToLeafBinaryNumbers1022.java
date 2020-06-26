package breadth_first_search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class SumofRootToLeafBinaryNumbers1022 {

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int sum = 0;
        while (!queue.isEmpty()) {
            final Pair<TreeNode, Integer> currentPair = queue.poll();
            final TreeNode currentNode = currentPair.getKey();
            final int currentVal = currentPair.getValue() + currentNode.val;
            final TreeNode left = currentNode.left;
            final TreeNode right = currentNode.right;
            if (left == null && right == null) {
                sum += currentVal;
            }
            if (left != null) {
                queue.offer(new Pair<>(left, currentVal << 1));
            }
            if (right != null) {
                queue.offer(new Pair<>(right, currentVal << 1));
            }
        }
        return sum;
    }

    /*
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int i) {
        final int current = i + node.val;
        final TreeNode left = node.left;
        final TreeNode right = node.right;
        if (left == null && right == null) {
            return current;
        }
        final int leftVal = left == null ? 0 : dfs(left, current << 1);
        final int rightVal = right == null ? 0 : dfs(right, current << 1);
        return leftVal + rightVal;
    }
     */

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
