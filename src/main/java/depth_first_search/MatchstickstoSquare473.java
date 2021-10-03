package depth_first_search;

import java.util.Arrays;

public class MatchstickstoSquare473 {
    int sideLength;
    int[] nums;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        this.nums = nums;
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
        return dfs(0, 0, new boolean[nums.length], 0);
    }

    private boolean dfs(int count, int index, boolean[] visited, int sum) {
        if (count == 4) {
            return true;
        }
        if (sum == sideLength) {
            return dfs(count + 1, 0, visited, 0);
        }
        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += nums[i];
                if (dfs(count, i + 1, visited, sum)) {
                    return true;
                }
                sum -= nums[i];
                visited[i] = false;
            }
        }
        return false;
    }
    /*
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
     */
}
