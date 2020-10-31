package dynamic_programming;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        final int[] lengthsLIS = new int[nums.length];
        final int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengthsLIS[j] >= lengthsLIS[i]) {
                        lengthsLIS[i] = lengthsLIS[j] + 1;
                        count[i] = count[j];
                    } else if (lengthsLIS[j] + 1 == lengthsLIS[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int longest = 0;
        int result = 0;
        for (int len : lengthsLIS) {
            longest = Math.max(len, longest);
        }
        for (int i = 0; i < nums.length; i++) {
            if (lengthsLIS[i] == longest) {
                result += count[i];
            }
        }
        return result;
    }
}
