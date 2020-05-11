package binary_search;

import java.util.Arrays;

public class CountNegativeNumbersinaSortedMatrix1351 {
    public int countNegatives(int[][] grid) {
        return Arrays.stream(grid)
                .mapToInt(this::search)
                .reduce(0, Integer::sum);
    }

    public int search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] >= 0) {
            return 0;
        }
        if (nums[left] < 0) {
            return nums.length;
        }
        return nums.length - right;
    }
}
