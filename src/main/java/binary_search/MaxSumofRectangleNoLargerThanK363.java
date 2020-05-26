package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumofRectangleNoLargerThanK363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int count = Integer.MIN_VALUE;
        final int[] rowSum = new int[matrix.length];
        final List<Integer> sortedSum = new ArrayList<>();
        for (int col = 0; col < matrix[0].length; col++) {
            Arrays.fill(rowSum, 0);
            for (int currentCol = col; currentCol >= 0; currentCol--) {
                sortedSum.clear();
                sortedSum.add(0);
                int currentSum = 0;
                for (int row = 0; row < matrix.length; row++) {
                    rowSum[row] += matrix[row][currentCol];
                    currentSum += rowSum[row];
                    final Integer element =
                            binarySearchFirstElementGreaterEqualThanTarget(
                                    sortedSum,
                                    currentSum - k);
                    if (element != null) {
                        count = Math.max(count, currentSum - element);
                        if (count == k) {
                            return k;
                        }
                    }
                    final Integer position =
                            binarySearchInsertPosition(sortedSum, currentSum);
                    if (position != null) {
                        sortedSum.add(position, currentSum);
                    }
                }
            }
        }
        return count;
    }

    private Integer binarySearchInsertPosition(List<Integer> nums, long target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                return null;
            }
            if (nums.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums.get(left) == target ||
                nums.get(right) == target
        ) {
            return null;
        }
        if (target <= nums.get(left)) {
            return left;
        } else if (target <= nums.get(right)) {
            return right;
            // return left +1;
        } else {
            return right + 1;
        }
    }

    private Integer binarySearchFirstElementGreaterEqualThanTarget(
            List<Integer> result,
            int target
    ) {
        int left = 0;
        int right = result.size() - 1;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (result.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (result.get(left) >= target) {
            return result.get(left);
        }
        if (result.get(right) >= target) {
            return result.get(right);
        }
        return null;
    }
    /*
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int count = Integer.MIN_VALUE;
        final int[][] dpMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dpMatrix.length; i++) {
            for (int j = 1; j < dpMatrix[0].length; j++) {
                dpMatrix[i][j] = matrix[i - 1][j - 1] +
                        dpMatrix[i - 1][j] +
                        dpMatrix[i][j - 1] -
                        dpMatrix[i - 1][j - 1];
            }
        }
        for (int i = 1; i < dpMatrix.length; i++) {
            for (int j = 1; j < dpMatrix[0].length; j++) {
                for (int ci = i; ci < dpMatrix.length; ci++) {
                    for (int cj = j; cj < dpMatrix[0].length; cj++) {
                        final int currentSum = dpMatrix[ci][cj] -
                                dpMatrix[ci - i][cj] -
                                dpMatrix[ci][cj - j] +
                                dpMatrix[ci - i][cj - j];
                        if (currentSum <= k) {
                            count = Math.max(count, currentSum);
                        }
                    }
                }
            }
        }
        return count;
    }
     */
}
