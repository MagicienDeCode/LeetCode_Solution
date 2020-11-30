package depth_first_search;

import java.util.Arrays;

public class MatchstickstoSquare473 {
    int sideLength;
    int[] nums;
    int[] sums;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        this.nums = nums;
        this.sums = new int[4];
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        final int sideLength = sum >> 2;
        if (sideLength * 4 != sum) {
            return false;
        }
        Arrays.sort(this.nums);
        this.sideLength = sideLength;
        return dfs(this.nums.length - 1);
    }

    private boolean dfs(int i) {
        if (i == -1) {
            return sums[0] == sums[1] && sums[2] == sums[1] && sums[2] == sums[3];
        }
        final int current = nums[i];
        for (int j = 0; j < 4; j++) {
            if (sums[j] + current <= sideLength) {
                sums[j] += current;
                if (dfs(i - 1)) {
                    return true;
                }
                sums[j] -= current;
            }
        }
        return false;
    }
}
