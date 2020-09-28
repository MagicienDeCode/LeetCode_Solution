package list_array;

public class SubarrayProductLessThanK713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int result = 0;
        int product = 1;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            product *= nums[end];
            while (product >= k) {
                product /= nums[start++];
            }
            result += end - start + 1;
        }
        return result;
    }
}
