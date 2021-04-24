package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnectionsinaNetwork1192 {

    int id = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        final int[][] visitedAndId = new int[n][2];
        for (int i = 0; i < visitedAndId.length; i++) {
            visitedAndId[i] = new int[]{-1, -1};
        }
        final List<List<Integer>> results = new LinkedList<>();
        id = 0;

        dfs(-1, 0, graph, visitedAndId, results);

        return results;
    }

    private void dfs(
            int parent,
            int current,
            List<Integer>[] graph,
            int[][] visitedAndId,
            List<List<Integer>> results
    ) {
        if (visitedAndId[current][0] == -1) {
            visitedAndId[current][0] = id;
            visitedAndId[current][1] = id;
            ++id;
        }
        for (int neighbor : graph[current]) {
            if (neighbor != parent) {
                if (visitedAndId[neighbor][0] == -1) {
                    dfs(current, neighbor, graph, visitedAndId, results);
                    visitedAndId[current][1] = Math.min(visitedAndId[current][1], visitedAndId[neighbor][1]);
                    if (visitedAndId[current][0] < visitedAndId[neighbor][1]) {
                        results.add(List.of(current, neighbor));
                    }
                } else {
                    visitedAndId[current][1] = Math.min(visitedAndId[current][1], visitedAndId[neighbor][1]);
                }
            }
        }
    }
}
