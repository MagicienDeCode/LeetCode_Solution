package depth_first_search;

public class ValidSudoku36 {

    final boolean[][] row = new boolean[9][9];
    final boolean[][] col = new boolean[9][9];
    final boolean[][] box = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    final int k = board[i][j] - '0' - 1;
                    final int boxIndex = i / 3 * 3 + j / 3;
                    row[i][k] = true;
                    col[j][k] = true;
                    box[boxIndex][k] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return dfs(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return dfs(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                final int k = c - '0' - 1;
                final int boxIndex = i / 3 * 3 + j / 3;
                row[i][k] = true;
                col[j][k] = true;
                box[boxIndex][k] = true;
                board[i][j] = c;
                if (dfs(board, i, j + 1)) {
                    return true;
                }
                row[i][k] = false;
                col[j][k] = false;
                box[boxIndex][k] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        final int number = c - '0' - 1;
        final int boxIndex = i / 3 * 3 + j / 3;
        return !row[i][number] && !col[j][number] && !box[boxIndex][number];
    }
}
