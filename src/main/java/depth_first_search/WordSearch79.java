package depth_first_search;

public class WordSearch79 {
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (result) {
                    return true;
                }
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, i, j, word, 0);
                }
            }
        }
        return result;
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            char[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    private void dfs(
            final char[][] board,
            final int x,
            final int y,
            final String word,
            final int current) {
        if (current == word.length() - 1) {
            result = true;
            return;
        }
        final char value = board[x][y];
        board[x][y] = '*';
        for (int index = 0; index < deltaX.length; index++) {
            final int nextX = x + deltaX[index];
            final int nextY = y + deltaY[index];
            if (inBound(board, nextX, nextY) &&
                    board[nextX][nextY] == word.charAt(current + 1) &&
                    !result) {
                dfs(board, nextX, nextY, word, current + 1);
            }
        }
        board[x][y] = value;
    }
    /*
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            char[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    private boolean dfs(
            final char[][] board,
            final int x,
            final int y,
            final String word,
            final int current) {
        if (current == word.length() - 1) {
            return true;
        }
        final char value = board[x][y];
        board[x][y] = '*';
        boolean result = false;
        for (int index = 0; index < deltaX.length; index++) {
            final int nextX = x + deltaX[index];
            final int nextY = y + deltaY[index];
            if (inBound(board, nextX, nextY) &&
            board[nextX][nextY] == word.charAt(current + 1) &&
            !result) {
                if (dfs(board, nextX, nextY, word, current + 1)) {
                    result = true;
                }
            }
        }
        board[x][y] = value;
        return result;
    }
     */
}
