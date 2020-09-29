package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        final int height = getHeight(root);
        final int width = 1 << height;

        final List<List<int[]>> valueIndex = new ArrayList<>();
        final Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, width >> 1));
        int currentDistance = width >> 2;
        while (!queue.isEmpty()) {
            final List<int[]> levels = new ArrayList<>();
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final Pair<TreeNode, Integer> current = queue.poll();
                final TreeNode node = current.getKey();
                final Integer index = current.getValue();
                levels.add(new int[]{node.val, index});
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, index - currentDistance));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, index + currentDistance));
                }
            }
            currentDistance >>= 1;
            valueIndex.add(levels);
        }
        // construct the result
        for (List<int[]> vIndex : valueIndex) {
            final List<String> levelResults = new LinkedList<>();
            int current = 0;
            for (int j = 1; j < width; j++) {
                if (current != vIndex.size() && vIndex.get(current)[1] == j) {
                    levelResults.add(vIndex.get(current)[0] + "");
                    ++current;
                } else {
                    levelResults.add("");
                }
            }
            results.add(levelResults);
        }
        return results;
    }

    private int getHeight(TreeNode root) {
        int level = 0;
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ++level;
        }
        return level;
    }

    public static void main(String[] args) {
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        final PrintBinaryTree655 java = new PrintBinaryTree655();
        final List<List<String>> result = java.printTree(node1);
        System.out.println(result);
    }
}
