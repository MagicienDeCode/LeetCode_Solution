package easy_easy;

public class ReshapetheMatrix566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        final int[][] results = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                final int current = i * c + j;
                final int mi = current / mat[0].length;
                final int mj = current % mat[0].length;
                results[i][j] = mat[mi][mj];
            }
        }
        return results;
    }
    /*
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        final int[] ints = new int[mat.length * mat[0].length];
        int index = 0;
        for (int[] value : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                ints[index++] = value[j];
            }
        }
        index = 0;
        final int[][] results = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                results[i][j] = ints[index++];
            }
        }
        return results;
    }
     */
}
