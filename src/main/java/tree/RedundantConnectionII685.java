package tree;

import java.util.*;

public class RedundantConnectionII685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // edge[1] -> edge[0] (parent)
        final HashMap<Integer, Integer> parent = new HashMap<>();
        final List<int[]> candidates = new LinkedList<>();
        for (int[] edge : edges) {
            if (parent.containsKey(edge[1])) {
                candidates.add(new int[]{parent.get(edge[1]), edge[1]});
                candidates.add(edge);
            } else {
                parent.put(edge[1], edge[0]);
            }
        }

        int root = orbit(1, parent).node;
        // if each node has exactly one parent, candidate is empty, so return the last edge that
        // edge[0] && edge[1] are both in seen
        if (candidates.isEmpty()) {
            Set<Integer> cycle = orbit(root, parent).seen;
            int[] ans = new int[]{0, 0};
            for (int[] edge : edges) {
                if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                    ans = edge;
                }
            }
            return ans;
        }
        // there are two candidates, remove the last edge
        // 1. if can NOT connect all nodes, remove another node, return candidates[0]
        // 2. else, return candidates[1]
        final HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
        }
        // remove last candidates[1]
        graph.get(candidates.get(1)[0]).remove(Integer.valueOf(candidates.get(1)[1]));
        // check the rest of graph is connect or not ?
        final boolean[] visited = new boolean[edges.length + 1];
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final int current = queue.poll();
                if (graph.containsKey(current)) {
                    for (int neighbor : graph.get(current)) {
                        if (!visited[neighbor]) {
                            queue.offer(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return candidates.get(0);
            }
        }
        return candidates.get(1);
    }

    /*
    find root!!
    start from node 1, if its parent is exist and not visited, then go next.
     */
    public OrbitResult orbit(int node, Map<Integer, Integer> parent) {
        Set<Integer> seen = new HashSet();
        while (parent.containsKey(node) && !seen.contains(node)) {
            seen.add(node);
            node = parent.get(node);
        }
        return new OrbitResult(node, seen);
    }

    static class OrbitResult {
        int node;
        Set<Integer> seen;

        OrbitResult(int n, Set<Integer> s) {
            node = n;
            seen = s;
        }
    }
}