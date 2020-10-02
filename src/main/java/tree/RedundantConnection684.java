package tree;

import java.util.*;

public class RedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges) {
        final List<Integer>[] graph = new ArrayList[edges.length + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && bfs(graph, edge[0], edge[1])) {
                return edge;
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return edges[0];
    }

    private boolean bfs(List<Integer>[] graph, int start, int end) {
        final Queue<Integer> queue = new LinkedList<>();
        final HashSet<Integer> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final int current = queue.poll();
                if (current == end) {
                    return true;
                }
                for (int neighbor : graph[current]) {
                    if (!set.contains(neighbor)) {
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
}
