package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        final int[] dp = new int[nums.length];
        final int[] links = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(links, -7);
        int max = 0;
        int start = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 &&
                        dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                    links[j] = i;
                    if (dp[j] > max) {
                        max = dp[j];
                        start = j;
                    }
                }
            }
        }
        final List<Integer> result = new ArrayList<>();
        while (start != -7) {
            result.add(nums[start]);
            start = links[start];
        }
        return result;
    }
}
