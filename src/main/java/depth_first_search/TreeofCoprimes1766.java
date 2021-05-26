package depth_first_search;

import java.util.*;

public class TreeofCoprimes1766 {

    final int[][] dp = new int[51][51];

    public int[] getCoprimes(int[] nums, int[][] edges) {
        if (nums.length == 1) {
            return new int[]{-1};
        }
        // minimize calculation, default -1
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        // build graph
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        final int[] results = new int[nums.length];
        // for a given value, we add its ancestor to a Stack in format [node,level]
        final Map<Integer, Stack<int[]>> valueAncestors = new HashMap<>();
        // dfs from node 0,level 0, to all
        dfs(0, -1, graph, nums, valueAncestors, results, 0);
        return results;
    }

    private void dfs(int current,
                     int parent,
                     Map<Integer, List<Integer>> graph,
                     int[] nums,
                     Map<Integer, Stack<int[]>> valueAncestors,
                     int[] results,
                     int currentLevel
    ) {
        int candidateAncestor = -1;
        int candidateLevel = -1;
        final int currentValue = nums[current];

        for (int value : valueAncestors.keySet()) {
            if (gcd(value, currentValue) == 1) {
                // for each value in map valueAncestors, if gcd result is 1, peek the top [node,level] in Stack
                final int[] currentAncestorLevel = valueAncestors.get(value).peek();
                // compare level, the closest ancestor means the node who has the largest level.
                if (currentAncestorLevel[1] > candidateLevel) {
                    candidateLevel = currentAncestorLevel[1];
                    candidateAncestor = currentAncestorLevel[0];
                }
            }
        }
        // assign result and add current value,node,level to map valueAncestors
        results[current] = candidateAncestor;
        valueAncestors.computeIfAbsent(nums[current], v -> new Stack<>()).push(new int[]{current, currentLevel});
        for (int neighbor : graph.get(current)) {
            if (neighbor != parent) {
                // for each neighbor, dfs
                dfs(neighbor, current, graph, nums, valueAncestors, results, currentLevel + 1);
                // after dfs, remove neighbor from map valueAncestors
                valueAncestors.get(nums[neighbor]).pop();
                // after pop, if map.get(value) is empty, remove value to avoid unnecessary loop. SEE=> for (int value : valueAncestors.keySet())
                if (valueAncestors.get(nums[neighbor]).isEmpty()) {
                    valueAncestors.remove(nums[neighbor]);
                }
            }
        }
    }

    // GCD, Greatest Common Divisor
    private int gcd(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int a = x;
        int b = y;
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        while (a % b != 0) {
            final int remainder = a % b;
            if (b < remainder) {
                a = remainder;
            } else {
                a = b;
                b = remainder;
            }
        }
        dp[x][y] = b;
        return b;
    }
}
