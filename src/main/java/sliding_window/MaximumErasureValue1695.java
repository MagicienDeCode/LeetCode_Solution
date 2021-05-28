package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue1695 {
    public int maximumUniqueSubarray(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (set.contains(nums[right])) {
                while (left < right && nums[left] != nums[right]) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    ++left;
                }
                ++left;
            } else {
                sum += nums[right];
                max = Math.max(max, sum);
                set.add(nums[right]);
            }
        }
        return max;
    }
}
