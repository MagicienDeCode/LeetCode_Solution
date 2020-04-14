package binarysearch;

public class Searcha2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0] == null ||
                matrix[0].length == 0
        ) {
            return false;
        }
        boolean result = false;
        for (int[] ints : matrix) {
            if (ints[matrix[0].length - 1] >= target) {
                if (search(ints, target) != -1) {
                    result = true;
                }
            }
        }

        return result;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
