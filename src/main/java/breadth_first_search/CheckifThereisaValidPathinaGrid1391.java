package breadth_first_search;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CheckifThereisaValidPathinaGrid1391 {
    public boolean hasValidPath(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited =
                new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            if (current[0] == grid.length - 1 &&
                    current[1] == grid[0].length - 1) {
                return true;
            }
            switch (grid[current[0]][current[1]]) {
                case 1: {
                    next(grid, queue, visited, current[0], current[1], LEFT);
                    next(grid, queue, visited, current[0], current[1], RIGHT);
                    break;
                }
                case 2: {
                    next(grid, queue, visited, current[0], current[1], UP);
                    next(grid, queue, visited, current[0], current[1], DOWN);
                    break;
                }
                case 3: {
                    next(grid, queue, visited, current[0], current[1], LEFT);
                    next(grid, queue, visited, current[0], current[1], DOWN);
                    break;
                }
                case 4: {
                    next(grid, queue, visited, current[0], current[1], RIGHT);
                    next(grid, queue, visited, current[0], current[1], DOWN);
                    break;
                }
                case 5: {
                    next(grid, queue, visited, current[0], current[1], UP);
                    next(grid, queue, visited, current[0], current[1], LEFT);
                    break;
                }
                case 6: {
                    next(grid, queue, visited, current[0], current[1], UP);
                    next(grid, queue, visited, current[0], current[1], RIGHT);
                    break;
                }
            }
        }
        return false;
    }

    private void next(
            int[][] grid,
            Queue<int[]> queue,
            boolean[][] visited,
            int x,
            int y,
            int direction
    ) {
        final int nextX = x + deltaX[direction];
        final int nextY = y + deltaY[direction];
        if (inBound(grid, nextX, nextY) &&
                !visited[nextX][nextY] &&
                map.get(direction).contains(grid[nextX][nextY])
        ) {
            queue.offer(new int[]{nextX, nextY});
            visited[nextX][nextY] = true;
        }
    }

    private final int[] deltaX = {-1, 1, 0, 0};
    private final int[] deltaY = {0, 0, -1, 1};

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private final Map<Integer, Set<Integer>> map =
            Map.of(
                    UP, Set.of(2, 3, 4),
                    DOWN, Set.of(2, 5, 6),
                    LEFT, Set.of(1, 4, 6),
                    RIGHT, Set.of(1, 3, 5)
            );

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
