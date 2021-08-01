package depth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakingALargeIsland827 {
    public int largestIsland(int[][] grid) {
        int result = 0;
        final int[][] group = new int[grid.length][grid.length];
        final List<Integer> area = new ArrayList<>();
        area.add(0, 0);
        int index = 1;
        // calculate each size of area
        final boolean[][] visited = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    final int currentArea = dfs(grid, i, j, visited, group, index);
                    area.add(currentArea);
                    index++;
                }
            }
        }
        // test 0 that has neighbor of 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    final Set<Integer> set = hasNeighborOne(grid, i, j, group);
                    if (!set.isEmpty()) {
                        int currentSize = 1;
                        for (int connectedIndex : set) {
                            currentSize += area.get(connectedIndex);
                        }
                        result = Math.max(result, currentSize);
                    }
                }
            }
        }
        return result == 0 ? grid[0][0] == 1 ? grid.length * grid.length : 1 : result;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited, int[][] group, int index) {
        visited[i][j] = true;
        group[i][j] = index;
        int result = 1;
        for (int k = 0; k < 4; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            if (inBound(grid, x, y) && grid[x][y] == 1 && !visited[x][y]) {
                result += dfs(grid, x, y, visited, group, index);
            }
        }
        return result;
    }

    private Set<Integer> hasNeighborOne(int[][] grid, int i, int j, int[][] group) {
        final Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            final int x = i + deltaX[k];
            final int y = j + deltaY[k];
            if (inBound(grid, x, y) && grid[x][y] == 1) {
                set.add(group[x][y]);
            }
        }
        return set;
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
}
