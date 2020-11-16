package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimetoCollectAllApplesinaTree1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        final ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ed : edges) {
            graph[ed[0]].add(ed[1]);
            graph[ed[1]].add(ed[0]);
        }
        return dfs(0, -1, hasApple, graph);
    }

    private int dfs(int now, int parent, List<Boolean> hasApple, ArrayList<Integer>[] graph) {
        int count = 0;
        for (int neighbor : graph[now]) {
            if (neighbor != parent) {
                count += dfs(neighbor, now, hasApple, graph);
            }
        }
        if (now == 0) {
            return count;
        }
        if (count == 0) {
            return hasApple.get(now) ? 2 : 0;
        }
        return count + 2;
    }

    public static void main(String[] args) {
        final MinimumTimetoCollectAllApplesinaTree1443 java = new MinimumTimetoCollectAllApplesinaTree1443();
        // 8
        System.out.println(java.minTime(
                7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, true, false, true, true, false)
        ));
        // 6
        System.out.println(java.minTime(
                7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, List.of(false, false, true, false, false, true, false)
        ));
    }
}
