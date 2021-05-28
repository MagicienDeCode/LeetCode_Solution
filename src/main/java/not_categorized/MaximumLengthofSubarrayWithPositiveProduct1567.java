package not_categorized;

public class MaximumLengthofSubarrayWithPositiveProduct1567 {
    public int getMaxLen(int[] nums) {
        int beginIndex = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result = Math.max(result, getMaxLenWithRange(nums, beginIndex, i - 1));
                beginIndex = i + 1;
            } else if (i == nums.length - 1) {
                result = Math.max(result, getMaxLenWithRange(nums, beginIndex, i));
            }
        }
        return result;
    }

    private int getMaxLenWithRange(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left] > 0 ? 1 : 0;
        }
        int firstNegative = -1;
        int lastNegative = -1;
        int countNegative = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] < 0) {
                ++countNegative;
                if (firstNegative == -1) {
                    firstNegative = i;
                }
                lastNegative = i;
            }
        }
        if (countNegative % 2 == 0) {
            return right - left + 1;
        } else {
            return Math.max(right - firstNegative, lastNegative - left);
        }
    }
}
