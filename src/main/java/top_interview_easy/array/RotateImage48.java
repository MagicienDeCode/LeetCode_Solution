package top_interview_easy.array;

public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // along the left top to right bottom diagonal line, swap symmetrical pair
        for (int i = 0; i < n; i++) {  // for each row
            for (int j = i + 1; j < n; j++) {  // for each number
                // swap the pair
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // flip each row horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;

            }
        }
    }
}
