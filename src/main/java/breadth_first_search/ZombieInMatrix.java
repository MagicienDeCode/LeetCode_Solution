package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int zombie(int[][] grid) {
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        final Queue<int[]> queue = new LinkedList<>();

        int peoples = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ++peoples;
                }
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        if (peoples == 0) {
            return 0;
        }
        int level = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                for (int index = 0; index < 4; index++) {
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    if (inBound(grid, nextX, nextY) &&
                            !visited[nextX][nextY] &&
                            grid[nextX][nextY] == 0) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        ++count;
                    }
                }
            }
            ++level;
        }
        return count == peoples ? --level : -1;
    }

    public static void main(String[] args) {
        final ZombieInMatrix java = new ZombieInMatrix();
        System.out.println(
                java.zombie(new int[][]{
                        {0, 1, 2, 0, 0},
                        {1, 0, 0, 2, 1},
                        {0, 1, 0, 0, 0}
                })
        );
    }
}
