package breadth_first_search;

public class SurroundedRegions130 {
    private boolean inBoardMinus1(
            int x,
            int y,
            int maxX,
            int maxY
    ) {
        return x > 0 && y > 0 && x < maxX - 1 && y < maxY - 1;
    }

    private final int[] deltaX = {0, 0, 1, -1};
    private final int[] deltaY = {1, -1, 0, 0};

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        final int maxX = board.length;
        final int maxY = board[0].length;
        final int[][] dp = new int[maxX][maxY];
        for (int index = 0; index < maxY; index++) {
            if (board[0][index] == 'O') {
                dfs(board, dp, 0, index, maxX, maxY);
            }
            if (board[maxX - 1][index] == 'O') {
                dfs(board, dp, maxX - 1, index, maxX, maxY);
            }
        }
        for (int index = 0; index < maxX; index++) {
            if (board[index][0] == 'O') {
                dfs(board, dp, index, 0, maxX, maxY);
            }
            if (board[index][maxY - 1] == 'O') {
                dfs(board, dp, index, maxY - 1, maxX, maxY);
            }
        }
        for (int i = 1; i < maxX - 1; i++) {
            for (int j = 1; j < maxY - 1; j++) {
                if (board[i][j] == 'O' && dp[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(
            char[][] board,
            int[][] dp,
            int x,
            int y,
            int maxX,
            int maxY
    ) {
        if (dp[x][y] == 0 && board[x][y] == 'O') {
            dp[x][y] = 1;
            for (int ii = 0; ii < deltaX.length; ii++) {
                final int nextX = x + deltaX[ii];
                final int nextY = y + deltaY[ii];
                if (inBoardMinus1(nextX, nextY, maxX, maxY)) {
                    dfs(board, dp, nextX, nextY, maxX, maxY);
                }
            }
        }
    }
    /*
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        final int maxX = board.length;
        final int maxY = board[0].length;
        final int[][] dp = new int[maxX][maxY];
        final Queue<Pair<Integer, Integer>> queue =
                new LinkedList<>();
        for (int index = 0; index < maxY; index++) {
            if (board[0][index] == 'O') {
                queue.offer(new Pair<>(0, index));
            }
            if (board[maxX - 1][index] == 'O') {
                queue.offer(new Pair<>(maxX - 1, index));
            }
        }
        for (int index = 0; index < maxX; index++) {
            if (board[index][0] == 'O') {
                queue.offer(new Pair<>(index, 0));
            }
            if (board[index][maxY - 1] == 'O') {
                queue.offer(new Pair<>(index, maxY - 1));
            }
        }
        final int[] deltaX = {0, 0, 1, -1};
        final int[] deltaY = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            final Pair<Integer, Integer> current = queue.poll();
            final int x = current.getKey();
            final int y = current.getValue();
            if (dp[x][y] == 0 && board[x][y] == 'O') {
                dp[x][y] = 1;
                for (int ii = 0; ii < deltaX.length; ii++) {
                    final int nextX = x + deltaX[ii];
                    final int nextY = y + deltaY[ii];
                    if (inBoardMinus1(nextX, nextY, maxX, maxY)) {
                        queue.offer(new Pair<>(nextX, nextY));
                    }
                }
            }
        }
        for (int i = 1; i < maxX - 1; i++) {
            for (int j = 1; j < maxY - 1; j++) {
                if (board[i][j] == 'O' && dp[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean inBoardMinus1(
            int x,
            int y,
            int maxX,
            int maxY
    ) {
        return x > 0 && y > 0 && x < maxX - 1 && y < maxY - 1;
    }
     */
}
