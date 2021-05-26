package depth_first_search;

import java.util.*;

public class FrogPositionAfterTSeconds1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) {
            return 1.0;
        }
        // build graph
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        // array time to record how many time to reach node at index [1,n]
        final int[] times = new int[n + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[1] = 0;
        // probability of node at index [1,n], default 0.0 which means unvisited
        final double[] probabilities = new double[n + 1];
        probabilities[1] = 1.0;

        dfs(1, 0, times, probabilities, t, graph);

        // times[target] == t, frog reach target at exactly t.
        // times[target] < 0, frog reach target before t and stay there.
        if (times[target] == t || times[target] < 0) {
            return probabilities[target];
        } else {
            return 0.0;
        }
    }

    private void dfs(int node, int currentTime, int[] times, double[] probabilities, int t, Map<Integer, List<Integer>> graph) {
        // after t, return
        if (currentTime > t) {
            return;
        }
        // count unvisited neighbors
        int count = 0;
        for (int neighbor : graph.get(node)) {
            if (probabilities[neighbor] == 0.0) {
                ++count;
            }
        }
        // no unvisited neighbor means "leaf node"
        if (count == 0) {
            times[node] = -1;
            return;
        }
        // foreach neighbor, assign probability and dfs
        for (int neighbor : graph.get(node)) {
            if (probabilities[neighbor] == 0.0) {
                probabilities[neighbor] = probabilities[node] / count;
                times[neighbor] = currentTime + 1;
                dfs(neighbor, currentTime + 1, times, probabilities, t, graph);
            }
        }
    }
}
