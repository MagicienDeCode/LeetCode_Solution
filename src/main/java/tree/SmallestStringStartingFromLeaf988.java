package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestStringStartingFromLeaf988 {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        final List<String> candidates = new ArrayList<>();
        final Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, ""));
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final Pair<TreeNode, String> currentPair = queue.poll();
                final TreeNode node = currentPair.getKey();
                final String value = currentPair.getValue();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, value + (char) ('a' + node.val)));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, value + (char) ('a' + node.val)));
                }
                if (node.left == null && node.right == null) {
                    candidates.add(value + (char) ('a' + node.val));
                }
            }
        }
        return candidates.stream()
                .map(it -> new StringBuilder(it).reverse().toString())
                .reduce((acc, it) -> {
                    if (acc.compareTo(it) < 0) {
                        return acc;
                    } else {
                        return it;
                    }
                }).orElse("");
    }

    public static void main(String[] args) {
        final SmallestStringStartingFromLeaf988 java = new SmallestStringStartingFromLeaf988();
        final TreeNode node0 = new TreeNode(0);
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node33 = new TreeNode(3);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node44 = new TreeNode(4);
        final TreeNode node4 = new TreeNode(4);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node33;
        node2.right = node44;
        System.out.println(java.smallestFromLeaf(node0));

    }
}
