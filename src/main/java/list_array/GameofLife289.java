package list_array;

public class GameofLife289 {
    public void gameOfLife(int[][] board) {
        // 1->0  2
        // 0->1  -1
        final int[] deltaX = {-1, 1, 0, 0, -1, -1, 1, 1};
        final int[] deltaY = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbors = 0;
                for (int k = 0; k < 8; k++) {
                    final int x = i + deltaX[k];
                    final int y = j + deltaY[k];
                    if (inBound(board, x, y) && board[x][y] > 0) {
                        ++liveNeighbors;
                    }
                }
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
