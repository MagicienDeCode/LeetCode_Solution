package not_categorized;

public class TransformtoChessboard782 {
    public int movesToChessboard(int[][] board) {
        // count how many ones in the first row and first col
        int rowOneCount = 0;
        int colOneCount = 0;
        for (int[] ints : board) {
            if (ints[0] == 1) {
                ++rowOneCount;
            }
        }
        for (int i : board[0]) {
            if (i == 1) {
                ++colOneCount;
            }
        }
        final int half = board.length >> 1;

        if (board.length % 2 == 0) {
            // if N is even, count of one must equal to half of N
            if (half != rowOneCount || half != colOneCount) {
                return -1;
            }
        } else {
            // if N is odd, count of one could be half or half+1
            if ((half != rowOneCount) && (half + 1 != rowOneCount)) {
                return -1;
            }
            if ((half != colOneCount) && (half + 1 != colOneCount)) {
                return -1;
            }
        }
        // if two adjacent row/col are same at the first row/col, they must be all 1 or all 0
        for (int i = 1; i < board.length; i++) {
            final boolean rowSame = board[i][0] == board[i - 1][0];
            final boolean colSame = board[0][i] == board[0][i - 1];
            for (int j = 1; j < board.length; j++) {
                if (rowSame && board[i - 1][j] != board[i][j]) {
                    return -1;
                }
                if (!rowSame && board[i - 1][j] == board[i][j]) {
                    return -1;
                }
                if (colSame && board[j][i - 1] != board[j][i]) {
                    return -1;
                }
                if (!colSame && board[j][i - 1] == board[j][i]) {
                    return -1;
                }
            }
        }
        int row = 0;
        int col = 0;
        if (board.length % 2 == 0) {
            // if N is even, suppose the first element is 0, calculate diff of row/col
            int rowDiff = 0;
            int colDiff = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] != row) {
                    rowDiff++;
                }
                if (board[0][i] != col) {
                    colDiff++;
                }
                row = 1 - row;
                col = 1 - col;
            }
            // (N - diff) suppose the first element is 1
            // swap two different row/cols only need 1 transform, so diff / 2
            return Math.min(rowDiff, board.length - rowDiff) / 2 + Math.min(colDiff, board.length - colDiff) / 2;
        } else {
            // if N is odd, determine the first element based on the count of one
            row = rowOneCount == half + 1 ? 1 : 0;
            col = colOneCount == half + 1 ? 1 : 0;
            int diff = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] != row) {
                    diff++;
                }
                if (board[0][i] != col) {
                    diff++;
                }
                row = 1 - row;
                col = 1 - col;
            }
            // since the first element is fixed, return diff / 2
            return diff >> 1;
        }
    }
}
