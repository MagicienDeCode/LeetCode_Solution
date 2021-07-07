package sliding_window;

public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (left < nums.length) {
            while (right < nums.length && nums[right] == 1) {
                max = Math.max(max, right - left + 1);
                ++right;
            }
            if (right == nums.length) {
                return max;
            }
            left = right;
            ++right;
        }
        return max;
    }
}
