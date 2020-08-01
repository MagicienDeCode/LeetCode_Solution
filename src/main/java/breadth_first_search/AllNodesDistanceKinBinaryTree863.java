package breadth_first_search;

import java.util.*;

public class AllNodesDistanceKinBinaryTree863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // build graph
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        final List<Integer> results = new LinkedList<>();
        if (root == null || target == null) {
            return results;
        }
        buildGraph(root.left, root, graph);
        buildGraph(root.right, root, graph);

        // visited queue
        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);
        visited.add(target.val);

        // bfs
        int level = 0;
        while (!queue.isEmpty()) {
            if (level == k) {
                while (!queue.isEmpty()) {
                    results.add(queue.poll());
                }
                return results;
            }
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int current = queue.poll();
                if (graph.containsKey(current)) {
                    graph.get(current).forEach(
                            it -> {
                                if (!visited.contains(it)) {
                                    queue.offer(it);
                                    visited.add(it);
                                }
                            }
                    );
                }
            }
            ++level;
        }
        return results;
    }

    private void buildGraph(
            TreeNode root,
            TreeNode parent,
            Map<Integer, List<Integer>> graph
    ) {
        if (root == null) {
            return;
        }
        graph.computeIfAbsent(root.val, v -> new ArrayList<>()).add(parent.val);
        graph.computeIfAbsent(parent.val, v -> new ArrayList<>()).add(root.val);
        buildGraph(root.left, root, graph);
        buildGraph(root.right, root, graph);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
