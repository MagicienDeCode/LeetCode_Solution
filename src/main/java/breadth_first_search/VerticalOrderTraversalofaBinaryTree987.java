package breadth_first_search;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class VerticalOrderTraversalofaBinaryTree987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        final List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        final Map<Integer, List<Integer>> map =
                new HashMap<>();
        final Queue<Pair<TreeNode, Integer>> queue =
                new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            final Map<Integer, List<Integer>> currentMap =
                    new HashMap<>();
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final Pair<TreeNode, Integer> current = queue.poll();
                final TreeNode node = current.getKey();
                final int xIndex = current.getValue();
                currentMap.computeIfAbsent(xIndex, v -> new ArrayList<>()).add(node.val);
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, xIndex - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, xIndex + 1));
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : currentMap.entrySet()) {
                final List<Integer> currentCollection = entry.getValue();
                Collections.sort(currentCollection);
                map.computeIfAbsent(entry.getKey(), v -> new ArrayList<>())
                        .addAll(currentCollection);
            }
        }
        return map.entrySet()
                .stream()
                .sorted(comparingByKey())
                .map(it -> it.getValue())
                .collect(Collectors.toList());
    }

    static class TreeNode {
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
