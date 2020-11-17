package tree;

import java.util.ArrayList;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero1466 {
    public int minReorder(int n, int[][] connections) {
        final ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(-conn[0]);
        }
        return dfs(0, -1, graph);
    }

    private int dfs(int now, int parent, ArrayList<Integer>[] graph) {
        int count = 0;
        for (int neighbor : graph[now]) {
            if (Math.abs(neighbor) != parent) {
                count += dfs(Math.abs(neighbor), now, graph) + (neighbor > 0 ? 1 : 0);
            }
        }
        return count;
    }
    /*
    public int minReorder(int n, int[][] connections) {
        final ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        final Map<Integer, HashSet<Integer>> original = new HashMap<>();
        for (int[] conn : connections) {
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(conn[0]);
            original.computeIfAbsent(conn[0], v -> new HashSet<>()).add(conn[1]);
        }
        return dfs(0, -1, graph, original);
    }

    private int dfs(int now, int parent, ArrayList<Integer>[] graph, Map<Integer, HashSet<Integer>> original) {
        int count = 0;
        for (int neighbor : graph[now]) {
            if (neighbor != parent) {
                count += dfs(neighbor, now, graph, original);
            }
        }
        if (now == 0) {
            return count;
        }
        if (original.containsKey(now) && original.get(now).contains(parent)) {
            return count;
        } else {
            return 1 + count;
        }
    }
     */
}
