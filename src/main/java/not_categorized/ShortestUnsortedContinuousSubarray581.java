package not_categorized;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {
    public int findUnsortedSubarray(int[] nums) {
        final int[] original = nums.clone();
        Arrays.sort(nums);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != original[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end >= start ? end - start + 1 : 0;
    }
}
