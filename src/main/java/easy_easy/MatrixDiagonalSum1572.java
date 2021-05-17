package easy_easy;

public class MatrixDiagonalSum1572 {
    public int diagonalSum(int[][] mat) {
        int left = 0;
        int right = mat[0].length - 1;
        int sum = 0;
        for (int[] ints : mat) {
            sum += ints[left];
            sum += ints[right];
            ++left;
            --right;
        }
        if (mat.length % 2 != 0) {
            sum -= mat[mat.length >> 1][mat[0].length >> 1];
        }
        return sum;
    }
}
