package list_array;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxCurrent = max;
            int minCurrent = min;
            max = Math.max(Math.max(nums[i], maxCurrent * nums[i]), minCurrent * nums[i]);
            min = Math.min(Math.min(nums[i], minCurrent * nums[i]), maxCurrent * nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }
}
