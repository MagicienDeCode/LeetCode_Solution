package list_array;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int current = 0;
        for (int n : nums) {
            current = Math.max(current + n, n);
            result = Math.max(result, current);
        }
        return result;
    }
}
