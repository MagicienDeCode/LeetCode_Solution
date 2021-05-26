package depth_first_search;

import java.util.Arrays;
import java.util.HashSet;

public class NQueensII52 {
    private int results = 0;

    public int totalNQueens(int n) {
        final String[][] grid = new String[n][n];
        for (int j = 0; j < n; j++) {
            Arrays.fill(grid[j], ".");
        }
        dfs(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), grid);
        return results;
    }

    private void dfs(int row, HashSet<Integer> diagonal1Visited, HashSet<Integer> diagonal2Visited, HashSet<Integer> colVisited, String[][] grid) {
        if (row == grid.length) {
            ++results;
            return;
        }
        for (int col = 0; col < grid.length; col++) {
            final int diagonal1 = row + col;
            final int diagonal2 = row - col;
            // if visited skip
            if (diagonal1Visited.contains(diagonal1) || diagonal2Visited.contains(diagonal2) || colVisited.contains(col)) {
                continue;
            }
            // set queen and visited
            grid[row][col] = "Q";
            diagonal1Visited.add(diagonal1);
            diagonal2Visited.add(diagonal2);
            colVisited.add(col);
            dfs(row + 1, diagonal1Visited, diagonal2Visited, colVisited, grid);
            // reset
            grid[row][col] = ".";
            diagonal1Visited.remove(diagonal1);
            diagonal2Visited.remove(diagonal2);
            colVisited.remove(col);
        }
    }
}
