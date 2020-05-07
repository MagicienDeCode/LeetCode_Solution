package binarysearch;

public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold1292 {
    public int maxSideLength(final int[][] mat, final int threshold) {
        final int[][] dynamicProgramming = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 1; i < dynamicProgramming.length; i++) {
            for (int j = 1; j < dynamicProgramming[0].length; j++) {
                dynamicProgramming[i][j] = mat[i - 1][j - 1] +
                        dynamicProgramming[i - 1][j] +
                        dynamicProgramming[i][j - 1] -
                        dynamicProgramming[i - 1][j - 1];
            }
        }
        int left = 0;
        int right = Math.min(mat.length, mat[0].length);
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (isValidSide(dynamicProgramming, threshold, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isValidSide(dynamicProgramming, threshold, right)) {
            return right;
        }
        return left;
    }

    private boolean isValidSide(final int[][] dynamicProgramming,
                                final int threshold,
                                final int side) {
        for (int i = side; i < dynamicProgramming.length; i++) {
            for (int j = side; j < dynamicProgramming[0].length; j++) {
                final int currentSum = dynamicProgramming[i][j] -
                        dynamicProgramming[i - side][j] -
                        dynamicProgramming[i][j - side] +
                        dynamicProgramming[i - side][j - side];
                if (currentSum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
