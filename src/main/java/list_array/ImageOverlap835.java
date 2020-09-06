package list_array;

public class ImageOverlap835 {
    public int largestOverlap(int[][] a, int[][] b) {
        int results = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                results = Math.max(results, shiftAndCount(i, j, a, b));
                results = Math.max(results, shiftAndCount(i, j, b, a));
            }
        }
        return results;
    }

    private int shiftAndCount(int i, int j, int[][] a, int[][] b) {
        int count = 0;
        int bRow = 0;
        for (int aRow = j; aRow < a.length; aRow++) {
            int bCol = 0;
            for (int aCol = i; aCol < b.length; aCol++) {
                if (a[aRow][aCol] == 1 && b[bRow][bCol] == 1) {
                    ++count;
                }
                ++bCol;
            }
            ++bRow;
        }
        return count;
    }
}
