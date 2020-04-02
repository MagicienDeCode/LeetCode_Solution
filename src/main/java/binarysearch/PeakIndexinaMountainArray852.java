package binarysearch;

public class PeakIndexinaMountainArray852 {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > nums[right] && nums[left - 1] < nums[left]) {
            return left;
        }
        return right;
    }
}
