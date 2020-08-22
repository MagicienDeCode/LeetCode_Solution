package breadth_first_search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCosttoMakeatLeastOneValidPathinaGrid1368 {
    public int minCost(int[][] grid) {
        final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (Comparator.comparingInt(ints -> ints[2]))
        );
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        priorityQueue.offer(new int[]{0, 0, 0});

        while (!priorityQueue.isEmpty()) {
            final int[] current = priorityQueue.poll();
            // end condition
            if (current[0] == grid.length - 1 &&
                    current[1] == grid[0].length - 1) {
                return current[2];
            }
            if (visited[current[0]][current[1]]) {
                continue;
            }
            visited[current[0]][current[1]] = true;
            for (int index = 0; index < 4; index++) {
                final int nextX = current[0] + deltaX[index];
                final int nextY = current[1] + deltaY[index];
                if (inBound(grid, nextX, nextY)) {
                    if (index + 1 == grid[current[0]][current[1]]) {
                        priorityQueue.offer(new int[]{nextX, nextY, current[2]});
                    } else {
                        priorityQueue.offer(new int[]{nextX, nextY, current[2] + 1});
                    }
                }
            }
        }

        return -1;
    }

    // right left down up
    private final int[] deltaX = {0, 0, 1, -1};
    private final int[] deltaY = {1, -1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
