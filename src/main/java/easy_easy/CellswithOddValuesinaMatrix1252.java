package easy_easy;

public class CellswithOddValuesinaMatrix1252 {
    public int oddCells(int m, int n, int[][] indices) {
        final int[] row = new int[m];
        final int[] col = new int[n];
        // count how many times we should add in each row,col
        for (int[] mn : indices) {
            row[mn[0]]++;
            col[mn[1]]++;
        }
        int count = 0;
        // no need to fill the original array, the value is times that we should modify at row[i] and col[j]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 == 1) {
                    ++count;
                }
            }
        }
        return count;
    }
}
