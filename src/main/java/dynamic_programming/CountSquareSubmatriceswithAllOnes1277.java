package dynamic_programming;

public class CountSquareSubmatriceswithAllOnes1277 {
    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = 1 + Math.min(
                            matrix[i - 1][j],
                            Math.min(
                                    matrix[i][j - 1],
                                    matrix[i - 1][j - 1]
                            )
                    );
                }
                count += matrix[i][j];
            }
        }
        return count;
    }
    /* 15ms
    public int countSquares(int[][] matrix) {
        final int[][] dynamicProgramming = new int[matrix.length][matrix[0].length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    dynamicProgramming[i][j] = 1 + Math.min(
                            dynamicProgramming[i - 1][j],
                            Math.min(
                                    dynamicProgramming[i][j - 1],
                                    dynamicProgramming[i - 1][j - 1]
                            )
                    );
                } else {
                    dynamicProgramming[i][j] = matrix[i][j];
                }
                count += dynamicProgramming[i][j];
            }
        }
        return count;
    }
     */
    /* 85ms
    public int countSquares(int[][] matrix) {
        final int[][] dynamicProgramming = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dynamicProgramming.length; i++) {
            for (int j = 1; j < dynamicProgramming[0].length; j++) {
                dynamicProgramming[i][j] = matrix[i - 1][j - 1] +
                        dynamicProgramming[i - 1][j] +
                        dynamicProgramming[i][j - 1] -
                        dynamicProgramming[i - 1][j - 1];
            }
        }
        int count = 0;
        int maxSide = Math.max(matrix.length, matrix[0].length);
        for (int side = 1; side <= maxSide; side++) {
            final int targetSum = side * side;
            for (int i = side; i < dynamicProgramming.length; i++) {
                for (int j = side; j < dynamicProgramming[0].length; j++) {
                    final int currentSum = dynamicProgramming[i][j] -
                            dynamicProgramming[i - side][j] -
                            dynamicProgramming[i][j - side] +
                            dynamicProgramming[i - side][j - side];
                    if (targetSum == currentSum) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
     */
}
