package binary_search;

import java.util.Arrays;

public class FindKthSmallestPairDistance719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            final int count = lessEqualThanTarget(nums, mid);
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (lessEqualThanTarget(nums, left) >= k) {
            return left;
        }
        return right;
    }

    private int lessEqualThanTarget(int[] nums, int target) {
        int count = 0;
        int start = 0;
        for (int index = 0; index < nums.length; index++) {
            while (start < nums.length && nums[index] - nums[start] > target) {
                ++start;
            }
            count += index - start;
        }
        return count;
    }
}
