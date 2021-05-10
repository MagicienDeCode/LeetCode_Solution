package depth_first_search;

public class RegionsCutBySlashes959 {

    private int row;
    private int col;
    private String[] grid;
    private boolean[][][] visited;

    public int regionsBySlashes(String[] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length();
        visited = new boolean[row][col][4];
        int count = 0;
        // foreach NOT visited row,col,type dfs and increase count
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        dfs(i, j, k);
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int type) {
        if (!inBound(i, j) || visited[i][j][type]) {
            return;
        }
        visited[i][j][type] = true;
        // go to next row,col
        switch (type) {
            case 0:
                dfs(i - 1, j, 2);
                break;
            case 1:
                dfs(i, j - 1, 3);
                break;
            case 2:
                dfs(i + 1, j, 0);
                break;
            case 3:
                dfs(i, j + 1, 1);
                break;
        }
        // in the same row col
        switch (type) {
            case 0:
                if (grid[i].charAt(j) != '/') {
                    dfs(i, j, 3);
                }
                if (grid[i].charAt(j) != '\\') {
                    dfs(i, j, 1);
                }
                break;
            case 1:
                if (grid[i].charAt(j) != '/') {
                    dfs(i, j, 2);
                }
                if (grid[i].charAt(j) != '\\') {
                    dfs(i, j, 0);
                }
                break;
            case 2:
                if (grid[i].charAt(j) != '/') {
                    dfs(i, j, 1);
                }
                if (grid[i].charAt(j) != '\\') {
                    dfs(i, j, 3);
                }
                break;
            case 3:
                if (grid[i].charAt(j) != '/') {
                    dfs(i, j, 0);
                }
                if (grid[i].charAt(j) != '\\') {
                    dfs(i, j, 2);
                }
                break;
        }
    }

    private boolean inBound(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
