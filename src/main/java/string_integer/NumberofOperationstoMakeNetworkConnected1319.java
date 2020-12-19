package string_integer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofOperationstoMakeNetworkConnected1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        final boolean[] visited = new boolean[n];
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], v -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], v -> new ArrayList<>()).add(connection[0]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, visited, graph);
            ++result;
        }
        return result - 1;
    }

    private void dfs(int i, boolean[] visited, Map<Integer, List<Integer>> graph) {
        visited[i] = true;
        if (graph.containsKey(i)) {
            graph.get(i).forEach(neighbor -> {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, graph);
                }
            });
        }
    }
    /*
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        final int[] reference = new int[n];

        for (int index = 0; index < reference.length; index++) {
            reference[index] = index;
        }

        for (int[] it : connections) {
            final int c1 = unionFind(reference, it[0]);
            final int c2 = unionFind(reference, it[1]);
            reference[c1] = c2;
        }

        int result = 0;
        for (int index = 0; index < reference.length; index++) {
            if (reference[index] == index) {
                ++result;
            }
        }
        return result - 1;
    }

    private int unionFind(int[] reference, int i) {
        return reference[i] == i ? i : unionFind(reference, reference[i]);
    }
     */
}
