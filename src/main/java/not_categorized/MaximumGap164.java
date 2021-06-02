package not_categorized;

import java.util.Arrays;

public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        final int volume = (max - min) / nums.length + 1;
        final int quantity = (max - min) / volume + 1;
        final int[] bucketMax = new int[quantity];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        final int[] bucketMin = new int[quantity];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int n : nums) {
            final int id = (n - min) / volume;
            bucketMax[id] = Math.max(bucketMax[id], n);
            bucketMin[id] = Math.min(bucketMin[id], n);
        }
        int result = 0;
        int pre = 0;
        for (int i = 1; i < quantity; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE || bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            result = Math.max(result, bucketMin[i] - bucketMax[pre]);
            pre = i;
        }
        return result;
    }
    /*
    public int maximumGap(int[] nums) {
        int maxGap = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
     */
}
