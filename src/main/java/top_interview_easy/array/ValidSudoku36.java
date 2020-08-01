package top_interview_easy.array;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        final boolean[][] row = new boolean[9][9];
        final boolean[][] col = new boolean[9][9];
        final boolean[][] box = new boolean[9][9];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                final char current = board[i][j];
                if (current != '.') {
                    final int number = current - '0' - 1;
                    final int boxIndex = i / 3 * 3 + j / 3;
                    if (row[i][number] || col[j][number] || box[boxIndex][number]) {
                        return false;
                    }
                    row[i][number] = true;
                    col[j][number] = true;
                    box[boxIndex][number] = true;
                }
            }
        }
        return true;
    }
}
