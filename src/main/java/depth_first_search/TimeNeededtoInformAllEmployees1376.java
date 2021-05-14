package depth_first_search;

import java.util.ArrayList;

public class TimeNeededtoInformAllEmployees1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        final ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                graph[manager[i]].add(i);
            }
        }
        return dfs(graph, new boolean[n], headID, informTime);
    }

    private int dfs(ArrayList<Integer>[] graph, boolean[] visited, int current, int[] informTime) {
        visited[current] = true;
        int time = 0;
        for (int employee : graph[current]) {
            if (!visited[employee]) {
                time = Math.max(dfs(graph, visited, employee, informTime), time);
            }
        }
        return time + informTime[current];
    }
}
