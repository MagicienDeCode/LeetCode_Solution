package binary_search;

import java.util.Arrays;

public class Heaters475 {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        // nlog(n)
        Arrays.sort(heaters);
        int result = 0;
        // mlog(n)
        for (int h : houses) {
            result = Math.max(result, searchMinDistance(heaters, h));
        }
        return result;
    }

    private int searchMinDistance(final int[] nums, final int target) {
        if (target < nums[0]) {
            return nums[0] - target;
        }
        if (target > nums[nums.length - 1]) {
            return target - nums[nums.length - 1];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return 0;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(target - nums[left], nums[right] - target);
    }
}
