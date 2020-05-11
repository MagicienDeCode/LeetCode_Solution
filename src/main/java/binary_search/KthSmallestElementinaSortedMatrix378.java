package binary_search;

public class KthSmallestElementinaSortedMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null ||
                matrix.length == 0 ||
                matrix[0] == null ||
                matrix[0].length == 0
        ) {
            return 0;
        }
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (countNotGreatThanTarget(matrix, mid) < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (countNotGreatThanTarget(matrix, left) >= k) {
            return left;
        }
        return right;
    }

    private int countNotGreatThanTarget(int[][] matrix, int target) {
        int total = 0;
        for (int[] ints : matrix) {
            total += countLastNotGreatThanTarget(ints, target);
        }
        return total;
    }

    private int countLastNotGreatThanTarget(int[] nums, int target) {
        if (nums[nums.length - 1] <= target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] <= target) {
            return right + 1;
        }
        if (nums[left] <= target) {
            return right;
        }
        return 0;
    }
}

