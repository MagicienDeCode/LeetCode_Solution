package binary_search;

public class SuperEggDrop887 {
    public int superEggDrop(int k, int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (test(mid, k, n)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (test(left, k, n)) {
            return left;
        }
        return right;
    }

    private boolean test(
            int target,
            int k,
            int n
    ) {
        int result = 0;
        int temp = 1;
        for (int i = 1; i <= k; i++) {
            temp *= target - i + 1;
            temp /= i;
            result += temp;
            if (result >= n) {
                return true;
            }
        }
        return result >= n;
    }
    /*
    public int superEggDrop(int k, int n) {
        final int[][] dp = new int[n + 1][k + 1];
        for (int time = 1; time <= n; time++) {
            dp[time][0] = 0;
            for (int egg = 1; egg <= k; egg++) {
                dp[time][egg] = dp[time - 1][egg - 1]
                        + dp[time - 1][egg] + 1;
                if (dp[time][egg] >= n) {
                    return time;
                }
            }
        }
        return n;
    }
     */
    /*
    public int superEggDrop(int k, int n) {
        final int[][] dp = new int[n + 1][k + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1);
        }
        for (int floor = 2; floor <= n; floor++) {
            dp[floor][1] = floor;
            for (int egg = 2; egg <= k; egg++) {
                dp[floor][egg] = 1 + binarySearch(dp, floor, egg);
            }
        }
        return dp[n][k];
    }

    private int binarySearch(int[][] dp, int floor, int egg) {
        int left = 2;
        int right = floor;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            final int broken = dp[mid - 1][egg - 1];
            final int notBroken = dp[floor - mid][egg];
            if (broken == notBroken) {
                return broken;
            } else if (broken < notBroken) {
                left = mid;
            } else {
                right = mid;
            }
        }
        final int leftVal = Math.max(
                dp[left - 1][egg - 1], dp[floor - left][egg]
        );
        final int rightVal = Math.max(
                dp[right - 1][egg - 1], dp[floor - right][egg]
        );
        return Math.min(leftVal, rightVal);
    }
     */
}
