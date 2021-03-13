package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors823 {
    public int numFactoredBinaryTrees(int[] arr) {
        final int mod = 1000000007;
        Arrays.sort(arr);
        final long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);

        final Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueIndex.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // product OK
                if (arr[i] % arr[j] == 0) {
                    final int right = arr[i] / arr[j];
                    if (valueIndex.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[valueIndex.get(right)]) % mod;
                    }
                }
            }
        }

        long result = 0;
        for (long l : dp) {
            result += l;
        }
        return (int) (result % mod);
    }
}
