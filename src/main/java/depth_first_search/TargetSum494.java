package depth_first_search;

public class TargetSum494 {
    int result;
    int sum;
    int[] nums;

    public int findTargetSumWays(int[] nums, int sum) {
        this.result = 0;
        this.sum = sum;
        this.nums = nums;
        dfs(0, 0);
        return result;
    }

    private void dfs(int index, int currentSum) {
        if (index == this.nums.length) {
            result += currentSum == this.sum ? 1 : 0;
        } else {
            currentSum += this.nums[index];
            dfs(index + 1, currentSum);
            currentSum -= this.nums[index];
            currentSum -= this.nums[index];
            dfs(index + 1, currentSum);
        }
    }
}
