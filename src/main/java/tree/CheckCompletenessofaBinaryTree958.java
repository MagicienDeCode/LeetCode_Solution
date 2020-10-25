package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        final Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int count = 0;
        int lastNodeValue = 1;
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            final Pair<TreeNode, Integer> pair = queue.poll();
            final TreeNode currentNode = pair.getKey();
            final int value = pair.getValue();
            count += 1;
            lastNodeValue = value;
            if (currentNode.left != null) {
                queue.offer(new Pair<>(currentNode.left, value * 2));
            }
            if (currentNode.right != null) {
                queue.offer(new Pair<>(currentNode.right, value * 2 + 1));
            }
        }
        return count == lastNodeValue;
    }
}
