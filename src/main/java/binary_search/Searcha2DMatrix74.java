package binary_search;

public class Searcha2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0] == null ||
                matrix[0].length == 0
        ) {
            return false;
        }
        final int targetRow = searchTargetRowIndex(matrix, target);
        if (targetRow == -1) {
            return false;
        }
        return search(matrix[targetRow], target) != -1;
    }

    private int searchTargetRowIndex(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target >= matrix[right][0]) {
            return right;
        }
        if (target >= matrix[left][0]) {
            return left;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
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
