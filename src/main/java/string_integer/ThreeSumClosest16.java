package string_integer;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                final int current = abs(target - sum);
                if (current == 0) {
                    return sum;
                }
                if (current < abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        // sum = 6 target = 2 diff =4
        return target - diff;
    }
}
