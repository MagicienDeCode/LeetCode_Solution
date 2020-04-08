package binarysearch;

public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int s, int[] nums) {
        final int[] sumsArray = new int[nums.length + 1];
        sumsArray[0] = 0;
        int minimumSize = Integer.MAX_VALUE;
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            final int resultInSumsArray = search(sumsArray, sum - s, index);
            if (resultInSumsArray != -1) {
                minimumSize = Math.min(minimumSize, index + 1 - resultInSumsArray);
            }
            sumsArray[index + 1] = sum;
        }

        return minimumSize == Integer.MAX_VALUE ? 0 : minimumSize;
    }


    private int search(int[] nums, int target, int max) {
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int right = max;
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
        if (target >= nums[right]) {
            return right;
        }
        if (target >= nums[left]) {
            return left;
        }
        return -1;
    }
}
