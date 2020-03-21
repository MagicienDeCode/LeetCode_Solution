package binarysearch;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
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
        if (target <= nums[left]) {
            return left;
        } else if (target <= nums[right]) {
            return right;
            // return left +1;
        } else {
            return right + 1;
        }
    }
}
