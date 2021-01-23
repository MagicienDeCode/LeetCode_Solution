package list_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorttheMatrixDiagonally1329 {
    public int[][] diagonalSort(int[][] mat) {
        final List<List<Integer>> matrix = new ArrayList<>();
        final int m = mat.length;
        final int n = mat[0].length;
        final int[] currentIndex = new int[m + n - 1];
        for (int i = 0; i < m + n - 1; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix.get(i - j + n - 1).add(mat[i][j]);
            }
        }
        for (List<Integer> diagonal : matrix) {
            Collections.sort(diagonal);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final int diagonal = i - j + n - 1;
                mat[i][j] = matrix.get(diagonal).get(currentIndex[diagonal]++);
            }
        }
        return mat;
    }
}
