package sliding_window;

public class MaxConsecutiveOnesIII1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int countZero = 0;
        int max = 0;
        while (left < nums.length) {
            while (right < nums.length && (nums[right] == 1 || countZero < k)) {
                if (nums[right] == 0) {
                    ++countZero;
                }
                max = Math.max(max, right - left + 1);
                ++right;
            }
            if (right == nums.length) {
                return max;
            }
            if (nums[left] == 0) {
                --countZero;
            }
            ++left;
        }
        return max;
    }
}
