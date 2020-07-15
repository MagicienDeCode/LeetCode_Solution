package breadth_first_search;

import java.util.*;

public class MinimumHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        if (n == 2) {
            return List.of(0, 1);
        }
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new HashSet<>()).add(edge[0]);
        }
        while (graph.size() > 2) {
            // retrieve all nodes which have one neighbor
            final List<Integer> currentLevel = new ArrayList<>();
            graph.forEach(
                    (i, mutableSet) -> {
                        if (mutableSet.size() == 1) {
                            currentLevel.add(i);
                        }
                    }
            );
            // 1. remove it from neighbors 2. remove it
            currentLevel.forEach(
                    it -> {
                        graph.get(graph.get(it).iterator().next()).remove(it);
                        graph.remove(it);
                    }
            );
        }
        return new ArrayList<>(graph.keySet());
    }
}
