package binarysearch;

public class FindMinimuminRotatedSortedArrayII154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                if (nums[mid] > nums[0]) {
                    if (nums[mid] < nums[nums.length - 1]) {
                        return nums[0];
                    } else {
                        left = mid;
                    }
                }
                if (nums[mid] <= nums[nums.length - 1]) {
                    right = mid;
                }
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
