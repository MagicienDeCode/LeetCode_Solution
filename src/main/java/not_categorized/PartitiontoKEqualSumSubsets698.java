package not_categorized;

public class PartitiontoKEqualSumSubsets698 {

    int k = 0;
    int partSum = 0;
    int[] nums;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        partSum = sum / k;
        if (partSum * k != sum) {
            return false;
        }
        this.k = k;
        return dfs(0, 0, new boolean[nums.length], 0);
    }

    private boolean dfs(int count, int index, boolean[] visited, int sum) {
        if (count == k) {
            return true;
        }
        if (sum == partSum) {
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
}
