package top_interview_easy.array;

public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // along the left top to right bottom diagonal line, swap symmetrical pair
        for (int i = 0; i < n; i++) {  // for each row
            for (int j = i + 1; j < n; j++) {  // for each number
                // swap the pair
                swap(matrix, i, j, j, i);
                /*
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                 */
            }
        }

        // mid vertical line, swap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
