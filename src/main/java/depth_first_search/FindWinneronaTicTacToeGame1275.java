package depth_first_search;

public class FindWinneronaTicTacToeGame1275 {

    private static final int A = 1;

    public String tictactoe(int[][] moves) {
        final int[] rows = new int[3];
        final int[] cols = new int[3];
        int diagonal = 0;
        int antiDiagonal = 0;
        int player = A;

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];

            rows[row] += player;
            cols[col] += player;
            if (row == col) {
                diagonal += player;
            }
            if (row + col == 2) {
                antiDiagonal += player;
            }

            // check
            if (Math.abs(rows[row]) == 3 ||
                    Math.abs(cols[col]) == 3 ||
                    Math.abs(diagonal) == 3 ||
                    Math.abs(antiDiagonal) == 3
            ) {
                return player == A ? "A" : "B";
            }

            player *= -1;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    /* Basic Solution m*n  n*n
    private static final int A = 7;

    public String tictactoe(int[][] moves) {
        final int[][] board = new int[3][3];
        int player = A;
        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            board[row][col] = player;

            // check win on row, col, diagonal, antiDiagonal
            if (checkRow(board, row, player) ||
                    checkCol(board, col, player) ||
                    row == col && checkDiagonal(board, player) ||
                    row + col == 2 && checkAntiDiagonal(board, player)
            ) {
                return player == A ? "A" : "B";
            }

            player *= -1;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean checkAntiDiagonal(int[][] board, int player) {
        // (0,2) (1,1) (2,0)
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int[][] board, int player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int[][] board, int col, int player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int[][] board, int row, int player) {
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }
     */
}
