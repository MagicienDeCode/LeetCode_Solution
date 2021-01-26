package binary_search;

import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinimumEffort1631 {
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (valid(mid, heights)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (valid(left, heights)) {
            return left;
        }
        return right;
    }

    private boolean valid(int effort, int[][] heights) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited = new boolean[heights.length][heights[0].length];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            final int queueSize = queue.size();
            for (int size = 0; size < queueSize; size++) {
                final int[] coordinate = queue.poll();
                final int i = coordinate[0];
                final int j = coordinate[1];
                // end condition
                if (i == heights.length - 1 && j == heights[0].length - 1) {
                    return true;
                }
                for (int k = 0; k < 4; k++) {
                    final int x = i + deltaX[k];
                    final int y = j + deltaY[k];
                    if (inBound(heights, x, y) &&
                            !visited[x][y] &&
                            Math.abs(heights[x][y] - heights[i][j]) <= effort
                    ) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return false;
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public static void main(String[] args) {
        final PathWithMinimumEffort1631 java = new PathWithMinimumEffort1631();
        System.out.println(java.minimumEffortPath(new int[][]{
                {1, 1000000}
        }));
        // 2 1 0
        System.out.println(java.minimumEffortPath(new int[][]{
                {1, 2, 2}, {3, 8, 2}, {5, 3, 5}
        }));
        System.out.println(java.minimumEffortPath(new int[][]{
                {1, 2, 3}, {3, 8, 4}, {5, 3, 5}
        }));
        System.out.println(java.minimumEffortPath(new int[][]{
                {1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}
        }));

    }
}
