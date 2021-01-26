package depth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeStates802 {
    private static final int SAFE = 7;
    private static final int NOT_SAFE = 9;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        final int[] dp = new int[graph.length];
        final List<Integer> results = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            final HashSet<Integer> set = new HashSet<>();
            set.add(i);
            if (dfs(graph, i, dp, set)) {
                results.add(i);
            }
        }
        return results;
    }

    private boolean dfs(int[][] graph, int i, int[] dp, HashSet<Integer> set) {
        if (dp[i] > 0) {
            return dp[i] == SAFE;
        }
        boolean flag = true;
        for (int neighbor : graph[i]) {
            if (set.contains(neighbor)) {
                flag = false;
                continue;
            }
            set.add(neighbor);
            flag &= dfs(graph, neighbor, dp, set);
            set.remove(neighbor);
        }
        dp[i] = flag ? SAFE : NOT_SAFE;
        return dp[i] == SAFE;
    }

    public static void main(String[] args) {
        final FindEventualSafeStates802 java = new FindEventualSafeStates802();
        // 2456
        java.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}).forEach(System.out::print);
        System.out.println();
        // 4
        java.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}).forEach(System.out::print);
    }
}
