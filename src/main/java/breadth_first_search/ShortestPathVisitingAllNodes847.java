package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes847 {
    public int shortestPathLength(int[][] graph) {
        // endKey,visited,queue
        final int endKey = (1 << graph.length) - 1;
        final boolean[][] visited =
                new boolean[graph.length][1 << graph.length];
        // node, cover state
        final Queue<int[]> queue = new LinkedList<>();
        // put all nodes into the queue
        for (int i = 0; i < graph.length; i++) {
            final int cover = 1 << i;
            queue.offer(new int[]{i, cover});
            visited[i][cover] = true;
        }
        // bfs
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                if (current[1] == endKey) {
                    return level;
                }
                for (int next : graph[current[0]]) {
                    final int nextState = (1 << next) | current[1];
                    if (!visited[next][nextState]) {
                        queue.offer(new int[]{next, nextState});
                        visited[next][nextState] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }
}
