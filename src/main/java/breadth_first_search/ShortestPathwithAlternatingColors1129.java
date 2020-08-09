package breadth_first_search;

import java.util.*;

public class ShortestPathwithAlternatingColors1129 {
    private static final int BLUE = 0;
    private static final int RED = 1;

    public int[] shortestAlternatingPaths(
            int n,
            int[][] redEdges,
            int[][] blueEdges
    ) {
        final Map<Integer, List<Integer>> redMap = new HashMap<>();
        for (int[] red : redEdges) {
            redMap.computeIfAbsent(red[0], v -> new ArrayList<>()).add(red[1]);
        }
        final Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] blue : blueEdges) {
            blueMap.computeIfAbsent(blue[0], v -> new ArrayList<>()).add(blue[1]);
        }
        final int[] resultArray = new int[n];
        Arrays.fill(resultArray, -1);
        bfs(n, redMap, blueMap, resultArray, BLUE);
        bfs(n, redMap, blueMap, resultArray, RED);
        return resultArray;
    }

    private void bfs(
            int n,
            Map<Integer, List<Integer>> redMap,
            Map<Integer, List<Integer>> blueMap,
            int[] resultArray,
            int color
    ) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited = new boolean[n][2];
        queue.offer(new int[]{0, color});
        visited[0][color] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                final int currentIndex = current[0];
                resultArray[currentIndex] =
                        resultArray[currentIndex] == -1 ?
                                level :
                                Math.min(
                                        resultArray[currentIndex],
                                        level
                                );
                final int currentColor = current[1];
                if (currentColor == RED) {
                    if (redMap.containsKey(currentIndex)) {
                        redMap.get(currentIndex)
                                .forEach(
                                        it -> {
                                            if (!visited[it][BLUE]) {
                                                queue.offer(new int[]{it, BLUE});
                                                visited[it][BLUE] = true;
                                            }
                                        }
                                );
                    }
                }
                if (currentColor == BLUE) {
                    if (blueMap.containsKey(currentIndex)) {
                        blueMap.get(currentIndex)
                                .forEach(
                                        it -> {
                                            if (!visited[it][RED]) {
                                                queue.offer(new int[]{it, RED});
                                                visited[it][RED] = true;
                                            }
                                        }
                                );
                    }
                }
            }
            ++level;
        }
    }
}
