package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofNodesintheSubTreeWiththeSameLabel1519 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        final Map<Integer, List<Integer>> graph =
                new HashMap<>();
        for (int[] it : edges) {
            graph.computeIfAbsent(it[0], v -> new ArrayList<>()).add(it[1]);
            graph.computeIfAbsent(it[1], v -> new ArrayList<>()).add(it[0]);
        }
        final int[] result = new int[n];
        final int[] value = new int[26];
        dfs(graph, result, value, 0, 99, labels);
        return result;
    }

    private void dfs(
            Map<Integer, List<Integer>> graph,
            int[] result,
            int[] value,
            int current,
            int previous,
            String labels
    ) {
        final int currentIndex = labels.charAt(current) - 'a';
        ++value[currentIndex];
        final int currentValue = value[currentIndex];
        if (graph.containsKey(current)) {
            graph.get(current).forEach(
                    it -> {
                        if (it != previous) {
                            dfs(graph, result, value, it, current, labels);
                        }
                    }
            );
        }
        result[current] = value[currentIndex] - currentValue + 1;
    }
}
