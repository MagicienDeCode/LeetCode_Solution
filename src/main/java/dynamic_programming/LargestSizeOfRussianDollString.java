package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSizeOfRussianDollString {
    public int largestDivisibleSubset(String[] array) {
        if (array.length == 0) {
            return 0;
        }
        Arrays.sort(array, Comparator.comparing(String::length));
        final int[] dp = new int[array.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].contains(array[i]) &&
                        dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max;
    }
}
