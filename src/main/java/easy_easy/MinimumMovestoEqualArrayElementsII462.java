package easy_easy;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            return count(nums, (nums[nums.length >> 1] + nums[nums.length / 2 - 1]) / 2);
        } else {
            return count(nums, nums[nums.length >> 1]);
        }
    }

    private int count(int[] nums, int i) {
        int count = 0;
        for (int n : nums) {
            count += n > i ? n - i : i - n;
        }
        return count;
    }
}
