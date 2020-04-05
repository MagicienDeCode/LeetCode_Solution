package binarysearch;

public class SearchinRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                if (nums[mid] >= nums[0]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                if (nums[mid] <= nums[nums.length - 1]) {
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            }
        }
        return nums[left] == target || nums[right] == target;
    }
}
